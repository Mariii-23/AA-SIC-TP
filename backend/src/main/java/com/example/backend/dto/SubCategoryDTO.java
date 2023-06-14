package com.example.backend.dto;

public class SubCategoryDTO {
    private int id;
    private String name;
    private byte[] image;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
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
}
