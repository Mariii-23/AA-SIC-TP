package com.example.backend.dto.productDTOs;

import com.example.backend.model.Product;

public class ProductSimpleDTO {
    private int id;
    private String name;
    private int image;
    private double price;

    public ProductSimpleDTO() {
    }

    public ProductSimpleDTO(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductSimpleDTO(Product product) {
        this.id = product.getiD();
        this.name = product.getName();
        this.image = product.getImages().get(0).getiD();
        this.price = product.getPrice();
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
