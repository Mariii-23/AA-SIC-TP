package com.example.backend.dto;

public class ItemDTO {
    private String name;
    private double price;

    private int quantity;
    private byte[] materialImage;

    public ItemDTO() {
    }

    public ItemDTO(String name, double price, int quantity, byte[] materialImage) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.materialImage = materialImage;
    }

    public ItemDTO(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public byte[] getMaterialImage() {
        return materialImage;
    }

    public void setMaterialImage(byte[] materialImage) {
        this.materialImage = materialImage;
    }
}
