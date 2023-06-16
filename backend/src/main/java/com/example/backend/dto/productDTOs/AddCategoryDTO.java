package com.example.backend.dto.productDTOs;

public class AddCategoryDTO {
    private String name;
    private byte[] image;

    public AddCategoryDTO() {
    }

    public AddCategoryDTO(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public AddCategoryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }
}
