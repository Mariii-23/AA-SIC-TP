package com.example.backend.dto;

public class EditCategoryDTO {
    private String name;
    private String image;

    public EditCategoryDTO() {
    }

    public EditCategoryDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }
}
