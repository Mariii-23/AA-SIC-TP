package com.example.backend.dto;

import java.util.List;

public class ProductDetailedDTO extends ProductSimpleDTO{
    private String description;
    List<MaterialDTO> materials;
    List<TechnicalInfoDTO> technicalInfo;
    List<ReviewDTO> reviews;
    List<byte[]> images;

    public ProductDetailedDTO() {
    }

    public ProductDetailedDTO(int id, String name, double price, String description, List<MaterialDTO> materials,
                              List<TechnicalInfoDTO> technicalInfo, List<ReviewDTO> reviews, List<byte[]> images) {
        super(id, name, price);
        this.description = description;
        this.materials = materials;
        this.technicalInfo = technicalInfo;
        this.reviews = reviews;
        this.images = images;
    }
    public List<MaterialDTO> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialDTO> materials) {
        this.materials = materials;
    }

    public List<TechnicalInfoDTO> getTechnicalInfo() {
        return technicalInfo;
    }

    public void setTechnicalInfo(List<TechnicalInfoDTO> technicalInfo) {
        this.technicalInfo = technicalInfo;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public List<byte[]> getImages() {
        return images;
    }

    public void setImages(List<byte[]> images) {
        this.images = images;
    }
}
