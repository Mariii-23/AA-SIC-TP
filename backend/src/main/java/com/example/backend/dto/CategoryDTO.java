package com.example.backend.dto;

import java.util.List;

public class CategoryDTO {
    private int id;
    private String name;
    private List<SubCategoryDTO> subCategories;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name, List<SubCategoryDTO> subCategories) {
        this.id = id;
        this.name = name;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SubCategoryDTO> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryDTO> subCategories) {
        this.subCategories = subCategories;
    }
}
