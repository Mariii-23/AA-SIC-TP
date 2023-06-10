package com.example.backend.services;

import com.example.backend.dto.ProductSimpleDTO;
import com.example.backend.dto.TechnicalInfoDTO;
import com.example.backend.model.*;
import com.example.backend.repositories.CategoryRep;
import com.example.backend.repositories.MaterialRep;
import com.example.backend.repositories.ProductRep;
import com.example.backend.repositories.SubCategoryRep;
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

    public void addProduct(String name, String description, double price, int categoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos){
        Category category = categoryRep.getReferenceById(categoryId);
        List<Material> materials = materialRep.findMaterialByIdList(materialIds);
        Product product = new Product(price, name, description, materials, category);
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

}
