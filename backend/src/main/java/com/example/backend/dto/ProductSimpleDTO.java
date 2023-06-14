package com.example.backend.dto;

public class ProductSimpleDTO {
    private int id;
    private String name;
    private byte[] image;
    private double price;

    public ProductSimpleDTO() {
    }

    public ProductSimpleDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ProductSimpleDTO(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductSimpleDTO(int id, String name, double price, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
