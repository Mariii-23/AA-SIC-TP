package com.example.backend.dto.orderDTOs;

public class AddProductToShoppingCartDTO {
    private int customerId;
    private int productId;
    private int materialId;
    private int quantity;

    public AddProductToShoppingCartDTO(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int costumerId) {
        this.customerId = costumerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
