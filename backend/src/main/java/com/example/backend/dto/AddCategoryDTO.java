package com.example.backend.dto;

public class AddCategoryDTO {
    private String name;
    private String image;

    public AddCategoryDTO() {
    }

    public AddCategoryDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public AddCategoryDTO(String name) {
        this.name = name;
        this.image = "";
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
