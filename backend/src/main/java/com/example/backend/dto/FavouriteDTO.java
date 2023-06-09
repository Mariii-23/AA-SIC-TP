package com.example.backend.dto;

public class FavouriteDTO {
    private String name;
    private double price;

    public FavouriteDTO() {
    }

    public FavouriteDTO(String name, double price) {
        this.name = name;
        this.price = price;
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
}
