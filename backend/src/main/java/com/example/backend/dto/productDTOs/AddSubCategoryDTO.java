package com.example.backend.dto.productDTOs;

public class AddSubCategoryDTO extends AddCategoryDTO {
    private int categoryId;

    public AddSubCategoryDTO() {
    }

    public AddSubCategoryDTO(String name, byte[] image, int categoryId) {
        super(name, image);
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
