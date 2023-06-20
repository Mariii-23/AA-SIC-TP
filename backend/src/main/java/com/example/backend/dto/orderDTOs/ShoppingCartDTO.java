package com.example.backend.dto.orderDTOs;

import java.util.List;

public class ShoppingCartDTO {
    private List<ItemDTO> items;
    private double total;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(List<ItemDTO> items, double total) {
        this.items = items;
        this.total = total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
