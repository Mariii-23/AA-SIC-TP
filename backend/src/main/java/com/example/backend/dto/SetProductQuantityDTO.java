package com.example.backend.dto;

public class SetProductQuantityDTO {
    private int itemId;
    private int quantity;

    public SetProductQuantityDTO(){

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
