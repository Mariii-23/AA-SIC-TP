package com.example.backend.dto;

public class AddCategoryDTO {
    private String name;
    private String description;

    public AddCategoryDTO() {
    }

    public AddCategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AddCategoryDTO(String name) {
        this.name = name;
        this.description = "";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
