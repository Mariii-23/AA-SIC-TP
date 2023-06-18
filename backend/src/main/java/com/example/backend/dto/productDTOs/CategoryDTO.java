package com.example.backend.dto.productDTOs;

import com.example.backend.model.Category;

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

    public CategoryDTO(Category category) {
        this.id = category.getiD();
        this.name = category.getName();
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
