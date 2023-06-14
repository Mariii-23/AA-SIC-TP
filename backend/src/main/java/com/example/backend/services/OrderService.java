package com.example.backend.services;

import com.example.backend.Exception.ItemNotFoundException;
import com.example.backend.Exception.OrderNotFoundException;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.dto.OrderDetailedDTO;
import com.example.backend.dto.OrderSimpleDTO;
import com.example.backend.event.EmailEvent;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderService {
    @Autowired
    private OrderRep orderRep;

    @Autowired
    private ItemRep itemRep;

    @Autowired
    private OrderItemRep orderItemRep;

    @Autowired
    private ShoppingCartRep shoppingCartRep;

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private ProductRep productRep;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<OrderSimpleDTO> getOrdersOfCostumer(int costumerId) throws UserNotFoundException {
        List<Order> orders;
        try {
            orders = orderRep.findByCustomer_iD(costumerId);
        } catch (Exception e) {
            throw new UserNotFoundException("Customer not found");
        }
        List<OrderSimpleDTO> result = new ArrayList<>();
        orders.forEach(order -> {
            result.add(new OrderSimpleDTO(order));
        });
        return result;
    }

    public List<OrderSimpleDTO> getAllOrders(){
        List<Order> orders = orderRep.findAll();
        List<OrderSimpleDTO> result = new ArrayList<>();
        orders.forEach(order -> {
            result.add(new OrderSimpleDTO(order));
        });
        return result;
    }

    public OrderDetailedDTO getOrder(int orderId) throws OrderNotFoundException {
        Order order = orderRep.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        return new OrderDetailedDTO(order);
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

    public void createOrder(int customerId, String address, boolean storePickUp) throws UserNotFoundException {
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
        for(Item item : cart.getItems()) {
            OrderItem orderItem = new OrderItem(item, order);
            itemRep.deleteById(item.getiD());
            orderItems.add(orderItem);
            total += orderItem.getPrice();
        }
        order.setTotal(total);
        order.setItems(orderItems);
        orderRep.save(order);
    }

    public void addProductToShoppingCart(int customerId, int productId, int materialId, int quantity) throws Exception {
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
        shoppingCartRep.save(cart);
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


}
