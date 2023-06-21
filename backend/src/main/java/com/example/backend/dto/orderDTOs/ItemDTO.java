package com.example.backend.dto.orderDTOs;

import java.text.DecimalFormat;

public class ItemDTO {
    private String name;
    private double price;
    private int quantity;
    private int materialId;
    private int productImageId;
    private int itemId;

    public ItemDTO() {
    }

    public ItemDTO(String name, double price, int quantity, int materialId, int productImageId, int itemId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.materialId = materialId;
        this.productImageId = productImageId;
        this.itemId = itemId;
    }

    public ItemDTO(String name, double price, int quantity, int itemId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImage(int productImageId) {
        this.productImageId = productImageId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }
}
