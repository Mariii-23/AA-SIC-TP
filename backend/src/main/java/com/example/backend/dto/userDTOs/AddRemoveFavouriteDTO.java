package com.example.backend.dto.userDTOs;

public class AddRemoveFavouriteDTO {
    private int customerId;
    private int productId;

    public AddRemoveFavouriteDTO() {
    }

    public AddRemoveFavouriteDTO(int customerId, int productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
