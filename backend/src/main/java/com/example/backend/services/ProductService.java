package com.example.backend.services;

import com.example.backend.dto.*;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {
    @Autowired
    private ProductRep productRep;

    @Autowired
    private CategoryRep categoryRep;

    @Autowired
    private SubCategoryRep subCategoryRep;

    @Autowired
    private MaterialRep materialRep;

    @Autowired
    private ImageRep imageRep;

    public void addProduct(String name, String description, double price, int categoryId, int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos, List<String> images){
        Category category = null;
        SubCategory subCategory = null;
        if(categoryId != 0){
            category = categoryRep.getReferenceById(categoryId);
        } else {
            subCategory = subCategoryRep.getReferenceById(subCategoryId);
        }
        List<Material> materials = materialRep.findMaterialByIdList(materialIds);
        Product product;
        if (categoryId != 0){
            product = new Product(price, name, description, materials, category);
        }else {
            product = new Product(price, name, description, materials, subCategory);
        }

        List<Image> imageList = images.stream().map(image -> new Image(image, product)).toList();
        product.setImages(imageList);
        List<TechnicalInfo> technicalInfos = infos.stream().map(info -> new TechnicalInfo(info.getName(), info.getDescription(), product)).toList();
        product.setInfos(technicalInfos);
        productRep.save(product);
    }

    public void addCategory(String name, String image){
        Category category = new Category(name, image);
        categoryRep.save(category);
    }

    public void addSubCategory(String name, String image, int categoryId){
        Category category = categoryRep.getReferenceById(categoryId);
        SubCategory subCategory = new SubCategory(name, image, category);
        subCategoryRep.save(subCategory);
    }


    public void addMaterial(String name, String image){
        Material material = new Material(name, image);
        materialRep.save(material);
    }

    public void addProductToCategory(int productId, int categoryId){
        Product product = productRep.getReferenceById(productId);
        Category category = categoryRep.getReferenceById(categoryId);
        product.setCategory(category);
        productRep.save(product);
    }

    public void addProductToSubCategory(int productId, int subCategoryId){
        Product product = productRep.getReferenceById(productId);
        SubCategory subCategory = subCategoryRep.getReferenceById(subCategoryId);
        product.setSubCategory(subCategory);
        productRep.save(product);
    }

    public List<ProductSimpleDTO> getProductsByCategory(int categoryId){
        Category category = categoryRep.getReferenceById(categoryId);
        List<Product> products = category.getProducts();
        category.getSubCategories().forEach(
                subCategory -> products.addAll(subCategory.getProducts()));
        return products.stream()
                .map(product -> new ProductSimpleDTO(product.getiD(), product.getName(), product.getPrice(), product.getImages().get(0).getPath()))
                .toList();
    }

    public List<ProductSimpleDTO> getProductsBySubCategory(int subCategoryId){
        SubCategory subCategory = subCategoryRep.getReferenceById(subCategoryId);
        List<Product> products = subCategory.getProducts();
        return products.stream()
                .map(product -> new ProductSimpleDTO(product.getiD(), product.getName(), product.getPrice(), product.getImages().get(0).getPath()))
                .toList();
    }

    public ProductDetailedDTO getProductById(int productId){
        Product product = productRep.getReferenceById(productId);
        return new ProductDetailedDTO(productId,
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getMaterials().stream().map(material -> new MaterialDTO(material.getID(), material.getName(), material.getImage())).toList(),
                product.getInfos().stream().map(info -> new TechnicalInfoDTO(info.getName(), info.getDescription())).toList(),
                product.getReviews().stream().map(review -> new ReviewDTO(review.getClassification(), review.getComment(), review.getAuthor().getName())).toList(),
                product.getImages().stream().map(Image::getPath).toList());
    }

}
