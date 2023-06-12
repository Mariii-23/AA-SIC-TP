package com.example.backend.services;

import com.example.backend.dto.*;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private TechnicalInfoRep technicalInfoRep;

    public void addProduct(String name, String description, double price, int categoryId, int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos, List<String> images){
        Category category = categoryRep.getReferenceById(categoryId);
        SubCategory subCategory;

        List<Material> materials = materialRep.findMaterialByIdList(materialIds);
        Product product;

        if (subCategoryId != 0 && subCategoryRep.findCategoryById(subCategoryId).getiD() == categoryId){
            subCategory = subCategoryRep.getReferenceById(subCategoryId);
            product = new Product(price, name, description, materials, category, subCategory);
        } else {
            product = new Product(price, name, description, materials, category);
        }

        Product finalProduct = product;
        List<Image> imageList = images.stream().map(image -> new Image(image, finalProduct)).toList();
        finalProduct.setImages(imageList);
        List<TechnicalInfo> technicalInfos = infos.stream().map(info -> new TechnicalInfo(info.getName(), info.getDescription(), finalProduct)).toList();
        finalProduct.setInfos(technicalInfos);
        productRep.save(finalProduct);
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

    public List<CategoryDTO> getAllCategories(){
        return categoryRep.findAll().stream()
                .map(category -> new CategoryDTO(category.getiD(),
                        category.getName(),
                        category.getImage(),
                        category.getSubCategories().stream()
                        .map(subCategory -> new SubCategoryDTO(subCategory.getiD(), subCategory.getName(), subCategory.getImage())).toList()))
                .toList();
    }

    public void addReview(int customerId, int productId, int classification, String comment){
        Product product = productRep.getReferenceById(productId);
        Customer customer = customerRep.getReferenceById(customerId);
        Review review = new Review(classification, comment, customer, product);
        product.addReview(review);
        productRep.save(product);
    }

    public void editCategory(int categoryId, String name, String image) {
        Category category = categoryRep.getReferenceById(categoryId);
        category.setName(name);
        category.setImage(image);
        categoryRep.save(category);
    }

    public boolean removeCategory(int categoryId) {
        Category category = categoryRep.getReferenceById(categoryId);
        if (category.getProducts().size() == 0){
            categoryRep.delete(category);
            return true;
        }
        return false;
    }

    public void editSubCategories(HashMap<Integer, EditCategoryDTO> subCategories) {
        for (Map.Entry<Integer, EditCategoryDTO> entry : subCategories.entrySet()){
            SubCategory subCategory = subCategoryRep.getReferenceById(entry.getKey());
            if (entry.getValue().getName() != null) subCategory.setName(entry.getValue().getName());
            if (entry.getValue().getImage() != null) subCategory.setImage(entry.getValue().getImage());
            subCategoryRep.save(subCategory);
        }
    }

    public void removeSubCategory(int subCategoryId) {
        SubCategory subCategory = subCategoryRep.getReferenceById(subCategoryId);
        List<Product> products = subCategory.getProducts();
        for (Product product : products){
            product.setSubCategory(null);
            productRep.save(product);
        }
        subCategoryRep.delete(subCategory);
    }

    public void removeProduct(int productId) {
        Product product = productRep.getReferenceById(productId);
        productRep.delete(product);
    }

    @Transactional
    public void editProduct(int productId, String name, String description, double price, int categoryId,
                            int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos) {
        Product product = productRep.getReferenceById(productId);
        if (name != null) product.setName(name);
        if (description != null) product.setDescription(description);
        if (price != 0) product.setPrice(price);
        if (categoryId != 0) {
            Category category = categoryRep.getReferenceById(categoryId);
            product.setCategory(category);
        }
        if (subCategoryId != 0) {
            SubCategory subCategory = subCategoryRep.getReferenceById(subCategoryId);
            product.setSubCategory(subCategory);
        }
        if (materialIds != null) {
            List<Material> materials = materialRep.findMaterialByIdList(materialIds);
            product.setMaterials(materials);
        }
        if (infos != null) {
            List<TechnicalInfo> oldInfos = product.getInfos();
            for (TechnicalInfo info : oldInfos){
                technicalInfoRep.deleteTechnicalInfoById(info.getiD());
            }

            List<TechnicalInfo> newInfos = infos.stream()
                    .map(info -> new TechnicalInfo(info.getName(), info.getDescription(), product))
                    .toList();
            technicalInfoRep.saveAll(newInfos);
        }
        productRep.save(product);
    }

    public void addProductImages(int productId, List<String> images) {
        Product product = productRep.getReferenceById(productId);
        List<Image> productImages = product.getImages();
        for(String image: images){
            Image newImage = new Image(image, product);
            productImages.add(newImage);
        }
        product.setImages(productImages);
        productRep.save(product);
    }

    public void removeProductImages(int productId, List<String> images) {
        for(String image: images){
            Image imageToRemove = imageRep.findByPath(image);
            if (imageToRemove.getProduct().getiD() == productId) imageRep.delete(imageToRemove);
        }
    }
}
