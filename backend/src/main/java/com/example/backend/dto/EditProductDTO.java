package com.example.backend.dto;

import java.util.List;

public class EditProductDTO {
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int subCategoryId;
    private List<Integer> materialIds;
    private List<TechnicalInfoDTO> infos;

    public EditProductDTO() {
    }

    public EditProductDTO(String name, String description, double price, int categoryId, int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.materialIds = materialIds;
        this.infos = infos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public List<Integer> getMaterialIds() {
        return materialIds;
    }

    public void setMaterialIds(List<Integer> materialIds) {
        this.materialIds = materialIds;
    }

    public List<TechnicalInfoDTO> getInfos() {
        return infos;
    }

    public void setInfos(List<TechnicalInfoDTO> infos) {
        this.infos = infos;
    }
}
