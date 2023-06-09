package com.example.backend.dto;

public class CreateOrderDTO {
    private int costumerId;
    private int shoppingCartId;
    private String address;
    private boolean storePickUp;

    public CreateOrderDTO(){

    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStorePickUp() {
        return storePickUp;
    }

    public void setStorePickUp(boolean storePickUp) {
        this.storePickUp = storePickUp;
    }
}
