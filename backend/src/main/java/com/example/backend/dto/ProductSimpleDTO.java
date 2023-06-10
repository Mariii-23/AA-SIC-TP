package com.example.backend.dto;

public class ProductSimpleDTO {
    private int id;
    private String name;
    private String image;
    private double price;

    public ProductSimpleDTO() {
    }

    public ProductSimpleDTO(int id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
