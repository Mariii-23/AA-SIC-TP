package com.example.backend.dto.productDTOs;

import com.example.backend.model.Image;
import com.example.backend.model.Product;

import java.util.List;

public class ProductDetailedDTO extends ProductSimpleDTO{
    private String description;
    List<MaterialDTO> materials;
    List<TechnicalInfoDTO> technicalInfo;
    List<ReviewDTO> reviews;
    List<Integer> images;

    private int categoryID;

    public ProductDetailedDTO() {
    }

    public ProductDetailedDTO(int id, String name, double price, String description, List<MaterialDTO> materials,
                              List<TechnicalInfoDTO> technicalInfo, List<ReviewDTO> reviews, List<Integer> images, int categoryID) {
        super(id, name, price);
        this.description = description;
        this.materials = materials;
        this.technicalInfo = technicalInfo;
        this.reviews = reviews;
        this.images = images;
        this.categoryID = categoryID;
    }

    public ProductDetailedDTO(Product product) {
        super(product.getiD(), product.getName(), product.getPrice());
        this.description = product.getDescription();
        this.materials = product.getMaterials().stream().map(MaterialDTO::new).toList();
        this.technicalInfo = product.getInfos().stream().map(TechnicalInfoDTO::new).toList();
        this.reviews = product.getReviews().stream().map(ReviewDTO::new).toList();
        this.images = product.getImages().stream().map(Image::getiD).toList();
        this.categoryID = product.getCategory().getiD();
    }
    public List<MaterialDTO> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialDTO> materials) {
        this.materials = materials;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
