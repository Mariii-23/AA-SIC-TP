package com.example.backend.services;

import com.example.backend.dto.orderDTOs.ItemDTO;
import com.example.backend.dto.orderDTOs.ShoppingCartDTO;
import com.example.backend.exception.ItemNotFoundException;
import com.example.backend.exception.OrderAlreadyPayedException;
import com.example.backend.exception.OrderNotFoundException;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.EnvelopeDTO;
import com.example.backend.dto.orderDTOs.OrderDetailedDTO;
import com.example.backend.dto.orderDTOs.OrderSimpleDTO;
import com.example.backend.event.EmailEvent;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderService {
    @Autowired
    private OrderRep orderRep;

    @Autowired
    private ItemRep itemRep;

    @Autowired
    private ShoppingCartRep shoppingCartRep;

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private ProductRep productRep;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public EnvelopeDTO<OrderSimpleDTO> getOrdersOfCustomer(int customerId, int offset, int numItems) throws UserNotFoundException {
        List<Order> orders;
        try {
            orders = orderRep.findCustomerOrdersPagination(customerId, offset, numItems);
        } catch (Exception e) {
            throw new UserNotFoundException("Customer not found");
        }
        List<OrderSimpleDTO> list = new ArrayList<>();
        orders.forEach(order -> {
            list.add(new OrderSimpleDTO(order));
        });
        boolean isLast = (offset + numItems) >= getNumberOfCustomerOrders(customerId);
        return new EnvelopeDTO<>(isLast, list);
    }

    public EnvelopeDTO<OrderSimpleDTO> getAllOrders(int offset, int numItems){
        List<Order> orders = orderRep.findOrdersPagination(offset, numItems + 1);
        boolean isLast;
        if(orders.size() == numItems + 1){
            isLast = false;
            orders.remove(orders.size() - 1);
        } else {
            isLast = true;
        }

        List<OrderSimpleDTO> list = new ArrayList<>();
        orders.forEach(order -> {
            list.add(new OrderSimpleDTO(order));
        });
        return new EnvelopeDTO<>(isLast, list);
    }

    public OrderDetailedDTO getOrder(int orderId) throws OrderNotFoundException {
        Order order = orderRep.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        List<ItemDTO> items = order.getItems()
                .stream().map(orderItem -> new ItemDTO(orderItem.getProduct().getName(),
                        orderItem.getPrice(),
                        orderItem.getQuantity(),
                        orderItem.getMaterial().getID(),
                        orderItem.getProduct().getImages().get(0).getiD(),
                        orderItem.getiD())).toList();
        return new OrderDetailedDTO(order, items);
    }

    public boolean setOrderState(int orderId, OrderState state) throws OrderNotFoundException {
        Order order = orderRep.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        String subject = "Order " + orderId + " state changed";
        String message = "Your order with id " + orderId + " is now " + state + ".";
        applicationEventPublisher.publishEvent(new EmailEvent(this, order.getCustomer(), subject, message));
        if(order.getState() != state){
            order.setState(state);
            orderRep.save(order);
            return true;
        }
        return false;
    }

    public OrderDetailedDTO createOrder(int customerId, String address, boolean storePickUp) throws Exception {
        Customer c = customerRep.findById(customerId).orElse(null);
        if (c == null) {
            throw new UserNotFoundException("Customer not found");
        }
        ShoppingCart cart = c.getCart();
        List<OrderItem> orderItems = new ArrayList<>();
        if (storePickUp) {
            address = "Store";
        }
        Order order = new Order(LocalDate.now(),address, storePickUp, OrderState.PENDING, c);
        double total = 0.0;
        List<Item> items = cart.getItems();
        if (items.isEmpty()) throw new Exception("Cart is empty");
        for(Item item : items){
            OrderItem orderItem = new OrderItem(item, order);
            itemRep.deleteById(item.getiD());
            orderItems.add(orderItem);
            total += orderItem.getPrice();
        }
        order.setTotal(total);
        order.setItems(orderItems);
        order = orderRep.saveAndFlush(order);
        return new OrderDetailedDTO(order, orderItems.stream().map(orderItem -> new ItemDTO(orderItem.getProduct().getName(),
                orderItem.getPrice(),
                orderItem.getQuantity(),
                orderItem.getMaterial().getID(),
                orderItem.getProduct().getImages().get(0).getiD(),
                orderItem.getiD())).toList());
    }

    public ShoppingCartDTO getShoppingCart(int id) throws UserNotFoundException {
        Customer customer = customerRep.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("Customer not found");
        }
        List<ItemDTO> items = new ArrayList<>();
        customer.getCart().getItems().forEach(item -> {
            items.add(new ItemDTO(item.getProduct().getName(),
                    item.getProduct().getPrice(),
                    item.getQuantity(),
                    item.getMaterial().getID(),
                    item.getProduct().getImages().get(0).getiD(),
                    item.getiD()));
        });
        return new ShoppingCartDTO(items, customer.getCart().getTotalPrice());
    }

    @Transactional
    public int addProductToShoppingCart(int customerId, int productId, int materialId, int quantity) throws Exception {
        Customer c = customerRep.findById(customerId).orElse(null);
        if (c == null) {
            throw new UserNotFoundException("Customer not found");
        }
        ShoppingCart cart = c.getCart();
        Object[] result;
        try {
            result = productRep.findProductAndMaterialById(productId, materialId).get(0);
        } catch (Exception e) {
            throw new Exception("Product or material not found");
        }
        Product p = (Product) result[0];
        Material m = (Material) result[1];
        Item item = new Item(quantity, m, p, cart);
        cart.addItem(item);
        item = itemRep.saveAndFlush(item);
        shoppingCartRep.save(cart);
        return item.getiD();
    }

    public void setProductQuantity(int itemId, int quantity) throws ItemNotFoundException {
        Item item = itemRep.findById(itemId).orElse(null);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        item.setQuantity(quantity);
        itemRep.save(item);
    }

    public void deleteItemFromShoppingCart(int itemId) throws ItemNotFoundException {
        Item item = itemRep.findById(itemId).orElse(null);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        itemRep.delete(item);
    }

    public int getNumberOfCustomerOrders(int id) throws UserNotFoundException {
        Customer c = customerRep.findById(id).orElse(null);
        if (c == null) {
            throw new UserNotFoundException("Customer not found");
        } else return c.getOrders().size();
    }

    public int getNumberOfOrders() {
        return (int) orderRep.count();
    }

    public boolean payOrder(int orderId) throws OrderNotFoundException, OrderAlreadyPayedException {
        Order order = orderRep.findById(orderId).orElse(null);
        if (order == null) throw new OrderNotFoundException("Order not found");
        if (order.getState() != OrderState.PENDING) throw new OrderAlreadyPayedException("Order already payed");
        order.setState(OrderState.READY);
        orderRep.save(order);
        return true;
    }

    public EnvelopeDTO<OrderSimpleDTO> getPendingOrders(int offset, int numItems) {
        List<Order> orders = orderRep.findPendingOrdersPagination(offset, numItems);
        List<OrderSimpleDTO> list = new ArrayList<>();
        orders.forEach(order -> {
            list.add(new OrderSimpleDTO(order));
        });
        boolean isLast = (offset + numItems) >= orderRep.countOrdersByState(OrderState.PENDING.ordinal());
        return new EnvelopeDTO<>(isLast, list);
    }

    public EnvelopeDTO<OrderSimpleDTO> getReadyOrders(int offset, int numItems) {
        List<Order> orders = orderRep.findReadyOrdersPagination(offset, numItems);
        List<OrderSimpleDTO> list = new ArrayList<>();
        orders.forEach(order -> {
            list.add(new OrderSimpleDTO(order));
        });
        boolean isLast = (offset + numItems) >= orderRep.countOrdersByState(OrderState.READY.ordinal());
        return new EnvelopeDTO<>(isLast, list);
    }

    public EnvelopeDTO<OrderSimpleDTO> getDoneOrders(int offset, int numItems) {
        List<Order> orders = orderRep.findDoneOrdersPagination(offset, numItems);
        List<OrderSimpleDTO> list = new ArrayList<>();
        orders.forEach(order -> {
            list.add(new OrderSimpleDTO(order));
        });
        boolean isLast = (offset + numItems) >= orderRep.countOrdersByState(OrderState.DONE.ordinal());
        return new EnvelopeDTO<>(isLast, list);
    }
}
