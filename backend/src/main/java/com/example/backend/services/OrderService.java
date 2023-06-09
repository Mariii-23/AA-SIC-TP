package com.example.backend.services;

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

    public List<OrderSimpleDTO> getOrderOfCostumer(int costumerId){
        List<Order> orders = orderRep.findByCustomer_iD(costumerId);
        List<OrderSimpleDTO> result = new ArrayList<>();
        orders.forEach(order -> {
            result.add(new OrderSimpleDTO(order));
        });
        return result;
    }

    public void createOrder(int customerId, int shoppingCartId, String address, boolean storePickUp){
        ShoppingCart cart = shoppingCartRep.getReferenceById(shoppingCartId);
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0.0;
        for(Item item : cart.getItems()){
            OrderItem orderItem = new OrderItem(item);
            itemRep.delete(item);
            orderItems.add(orderItem);
            total += orderItem.getPrice();
        }
        Customer c = customerRep.getReferenceById(customerId);
        Order order = new Order(LocalDate.now(),address, storePickUp, total, orderItems, OrderState.PENDING, c);
        orderRep.save(order);
    }


}
