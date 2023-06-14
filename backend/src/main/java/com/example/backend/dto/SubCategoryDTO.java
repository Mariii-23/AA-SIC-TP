package com.example.backend.dto;

public class SubCategoryDTO {
    private int id;
    private String name;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
