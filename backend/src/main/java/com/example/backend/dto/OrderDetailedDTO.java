package com.example.backend.dto;


import com.example.backend.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailedDTO extends OrderSimpleDTO {
    private List<ItemDTO> items = new ArrayList<>();

    public OrderDetailedDTO(Order order){
        super(order);
        order.getItems().forEach(orderItem -> {
            items.add(new ItemDTO(orderItem.getProduct().getName(),
                                  orderItem.getPrice(),
                                  orderItem.getQuantity(),
                                  orderItem.getMaterial().getImage()));
        });
    }

}
