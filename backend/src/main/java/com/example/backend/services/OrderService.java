package com.example.backend.services;

import com.example.backend.dto.OrderDetailedDTO;
import com.example.backend.dto.OrderSimpleDTO;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<OrderSimpleDTO> getOrdersOfCostumer(int costumerId){
        List<Order> orders = orderRep.findByCustomer_iD(costumerId);
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

    public OrderDetailedDTO getOrder(int orderId){
        Order order = orderRep.getReferenceById(orderId);
        return new OrderDetailedDTO(order);
    }

    public boolean setOrderState(int orderId, OrderState state){
        Order order = orderRep.getReferenceById(orderId);
        if(order.getState() != state){
            order.setState(state);
            orderRep.save(order);
            return true;
        }
        return false;
    }

    public void createOrder(int customerId, String address, boolean storePickUp){
        Customer c = customerRep.getReferenceById(customerId);
        ShoppingCart cart = c.getCart();
        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order(LocalDate.now(),address, storePickUp, OrderState.PENDING, c);
        double total = 0.0;
        for(Item item : cart.getItems()) {
            OrderItem orderItem = new OrderItem(item, order);
            itemRep.delete(item);
            orderItems.add(orderItem);
            total += orderItem.getPrice();
        }
        order.setTotal(total);
        order.setItems(orderItems);
        orderRep.save(order);
    }

    public void addProductToShoppingCart(int customerId, int productId, int materialId, int quantity){
        Customer c = customerRep.getReferenceById(customerId);
        ShoppingCart cart = c.getCart();
        Object[] result = productRep.findProductAndMaterialById(productId, materialId).get(0);
        Product p = (Product) result[0];
        Material m = (Material) result[1];
        Item item = new Item(quantity, m, p, cart);
        itemRep.save(item);
    }

    public void setProductQuantity(int itemId, int quantity){
        Item item = itemRep.getReferenceById(itemId);
        item.setQuantity(quantity);
        itemRep.save(item);
    }

    public void deleteItemFromShoppingCart(int itemId){
        Item item = itemRep.getReferenceById(itemId);
        itemRep.delete(item);
    }


}
