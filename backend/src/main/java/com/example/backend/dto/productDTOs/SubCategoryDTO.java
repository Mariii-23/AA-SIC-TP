package com.example.backend.dto.productDTOs;

import com.example.backend.model.SubCategory;

public class SubCategoryDTO {
    private int id;
    private String name;

    private int categoryId;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(int id, String name, int categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubCategoryDTO(SubCategory subCategory) {
        this.id = subCategory.getiD();
        this.name = subCategory.getName();
        this.categoryId = subCategory.getCategory().getiD();
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
