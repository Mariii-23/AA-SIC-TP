package com.example.backend.dto;

import java.util.List;

public class CategoryDTO {
    private int id;
    private String name;
    private String image;
    private List<SubCategoryDTO> subCategories;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name, String image, List<SubCategoryDTO> subCategories) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<SubCategoryDTO> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryDTO> subCategories) {
        this.subCategories = subCategories;
    }
}
