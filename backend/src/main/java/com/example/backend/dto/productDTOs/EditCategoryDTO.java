package com.example.backend.dto.productDTOs;

public class EditCategoryDTO {
    private String name;
    private byte[] image;

    public EditCategoryDTO() {
    }

    public EditCategoryDTO(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getImage() {
        return this.image;
    }
}
