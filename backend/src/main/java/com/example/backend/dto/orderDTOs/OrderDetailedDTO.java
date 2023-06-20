package com.example.backend.dto.orderDTOs;


import com.example.backend.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailedDTO extends OrderSimpleDTO {
    private List<ItemDTO> items = new ArrayList<>();

    public OrderDetailedDTO(Order order, List<ItemDTO> items) {
        super(order);
        this.items = items;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
