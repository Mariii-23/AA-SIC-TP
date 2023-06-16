package com.example.backend.dto.userDTOs;

public class AddRemoveFavouriteDTO {
    private int costumerId;
    private int productId;

    public AddRemoveFavouriteDTO() {
    }

    public AddRemoveFavouriteDTO(int costumerId, int productId) {
        this.costumerId = costumerId;
        this.productId = productId;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
