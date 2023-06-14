package com.example.backend.services;

import com.example.backend.Exception.*;
import com.example.backend.dto.*;
import com.example.backend.event.EmailEvent;
import com.example.backend.model.*;
import com.example.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void addProduct(String name, String description, double price, int categoryId, int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos, List<byte[]> images) throws Exception {
        Category category = categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        SubCategory subCategory;

        List<Material> materials = materialRep.findMaterialByIdList(materialIds).orElseThrow(() -> new Exception("Material not found"));
        Product product;

        if (subCategoryId != 0 && subCategoryRep.findCategoryById(subCategoryId).getiD() == categoryId){
            subCategory = subCategoryRep.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
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

    public void addCategory(String name, byte[] image){
        Category category = new Category(name, image);
        categoryRep.save(category);
    }

    public void addSubCategory(String name, byte[] image, int categoryId){
        Category category = categoryRep.getReferenceById(categoryId);
        SubCategory subCategory = new SubCategory(name, image, category);
        subCategoryRep.save(subCategory);
    }


    public void addMaterial(String name, byte[] image){
        Material material = new Material(name, image);
        materialRep.save(material);
    }

    public void addProductToCategory(int productId, int categoryId) throws ProductNotFoundException, CategoryNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Category category = categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        product.setCategory(category);
        productRep.save(product);
    }

    public void addProductToSubCategory(int productId, int subCategoryId) throws SubCategoryNotFoundException, ProductNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        SubCategory subCategory = subCategoryRep.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
        product.setSubCategory(subCategory);
        productRep.save(product);
    }

    public EnvelopeDTO<ProductSimpleDTO> getProductsByCategory(int categoryId, int offset, int numItems) throws CategoryNotFoundException {
        categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        List<Product> products = productRep.findByCategoryPagination(categoryId, offset, numItems);
        List<ProductSimpleDTO> list = products.stream()
                .map(product -> new ProductSimpleDTO(product.getiD(), product.getName(), product.getPrice(), product.getImages().get(0).getImage()))
                .toList();
        boolean isLast = (offset + numItems) >= getNumberOfProductsByCategory(categoryId);
        return new EnvelopeDTO<>(isLast,list);
    }

    public EnvelopeDTO<ProductSimpleDTO> getProductsBySubCategory(int subCategoryId, int offset, int numItems) throws SubCategoryNotFoundException {
        subCategoryRep.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
        List<Product> products = productRep.findBySubcategoryPagination(subCategoryId, offset, numItems);
        List<ProductSimpleDTO> list = products.stream()
                .map(product -> new ProductSimpleDTO(product.getiD(), product.getName(), product.getPrice(), product.getImages().get(0).getImage()))
                .toList();
        boolean isLast = (offset + numItems) >= getNumberOfProductsBySubCategory(subCategoryId);
        return new EnvelopeDTO<>(isLast,list);
    }

    public ProductDetailedDTO getProductById(int productId) throws ProductNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return new ProductDetailedDTO(productId,
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getMaterials().stream().map(material -> new MaterialDTO(material.getID(), material.getName(), material.getImage())).toList(),
                product.getInfos().stream().map(info -> new TechnicalInfoDTO(info.getName(), info.getDescription())).toList(),
                product.getReviews().stream().map(review -> new ReviewDTO(review.getClassification(), review.getComment(), review.getAuthor().getName())).toList(),
                product.getImages().stream().map(Image::getImage).toList());
    }

    public EnvelopeDTO<CategoryDTO> getAllCategories(int offset, int numItems){
        List<Category> categories = categoryRep.findAllPagination(offset, numItems);
        List<CategoryDTO> list = categories.stream()
                .map(category -> new CategoryDTO(category.getiD(),
                        category.getName(),
                        category.getImage(),
                        category.getSubCategories().stream()
                        .map(subCategory -> new SubCategoryDTO(subCategory.getiD(), subCategory.getName(), subCategory.getImage())).toList()))
                .toList();
        boolean isLast = (offset + numItems) >= getNumberOfCategories();
        return new EnvelopeDTO<>(isLast,list);
    }

    public void addReview(int customerId, int productId, int classification, String comment) throws ProductNotFoundException, UserNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Customer customer = customerRep.findById(customerId).orElseThrow(() -> new UserNotFoundException("Customer not found"));
        Review review = new Review(classification, comment, customer, product);
        product.addReview(review);
        productRep.save(product);
    }

    public void editCategory(int categoryId, String name, byte[] image) throws CategoryNotFoundException {
        Category category = categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        category.setName(name);
        category.setImage(image);
        categoryRep.save(category);
    }

    public boolean removeCategory(int categoryId) throws CategoryNotFoundException {
        Category category = categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        if (category.getProducts().size() == 0){
            categoryRep.delete(category);
            return true;
        }
        return false;
    }

    public void editSubCategories(HashMap<Integer, EditCategoryDTO> subCategories) throws SubCategoryNotFoundException {
        List<SubCategory> subCategoryList = new ArrayList<>();
        for (Map.Entry<Integer, EditCategoryDTO> entry : subCategories.entrySet()){
            SubCategory subCategory = subCategoryRep.findById(entry.getKey()).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
            if (entry.getValue().getName() != null) subCategory.setName(entry.getValue().getName());
            if (entry.getValue().getImage() != null) subCategory.setImage(entry.getValue().getImage());
            subCategoryList.add(subCategory);
        }
        subCategoryRep.saveAll(subCategoryList);
    }

    public void removeSubCategory(int subCategoryId) throws SubCategoryNotFoundException {
        SubCategory subCategory = subCategoryRep.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
        List<Product> products = subCategory.getProducts();
        for (Product product : products){
            product.setSubCategory(null);
            productRep.save(product);
        }
        subCategoryRep.delete(subCategory);
    }

    public void removeProduct(int productId) throws ProductNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRep.delete(product);
    }

    @Transactional
    public void editProduct(int productId, String name, String description, double price, int categoryId,
                            int subCategoryId, List<Integer> materialIds, List<TechnicalInfoDTO> infos) throws ProductNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        if (name != null) product.setName(name);
        if (description != null) product.setDescription(description);
        if (price != 0){
            String subject = "Price change";
            String message = "The price from the product " + product.getName() + " of your favorites list has changed from " + product.getPrice() + " to " + price;
            product.getCustomers().stream().forEach(customer -> applicationEventPublisher.publishEvent(new EmailEvent(this, customer, subject, message)));
            product.setPrice(price);
        }
        if (categoryId != 0) {
            Category category = categoryRep.getReferenceById(categoryId);
            product.setCategory(category);
        }
        if (subCategoryId != 0) {
            SubCategory subCategory = subCategoryRep.getReferenceById(subCategoryId);
            product.setSubCategory(subCategory);
        }
        if (materialIds != null) {
            List<Material> materials = materialRep.findMaterialByIdList(materialIds).orElseThrow(() -> new ProductNotFoundException("Material not found"));
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

    public void addProductImages(int productId, List<byte[]> images) throws ProductNotFoundException {
        Product product = productRep.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        List<Image> productImages = product.getImages();
        for(byte[] image: images){
            Image newImage = new Image(image, product);
            productImages.add(newImage);
        }
        product.setImages(productImages);
        productRep.save(product);
    }

    public void removeProductImages(int productId, List<byte[]> images) {
        for(byte[] image: images){
            Image imageToRemove = imageRep.findByImage(image);
            if (imageToRemove.getProduct().getiD() == productId) imageRep.delete(imageToRemove);
        }
    }

    public void editMaterial(int materialId, String name, byte[] image) throws MaterialNotFoundException {
        Material material = materialRep.findById(materialId).orElseThrow(() -> new MaterialNotFoundException("Material not found"));
        if (name != null) material.setName(name);
        if (image != null) material.setImage(image);
        materialRep.save(material);
    }

    public void removeMaterial(int materialId) throws MaterialNotFoundException {
        Material material = materialRep.findById(materialId).orElseThrow(() -> new MaterialNotFoundException("Material not found"));
        List<Product> products = material.getProducts();
        for (Product product : products){
            product.removeMaterial(material);
            if (product.getMaterials().size() == 0) productRep.delete(product);
            else productRep.save(product);
        }
        materialRep.delete(material);
    }

    public int getNumberOfProductsByCategory(int categoryId) throws CategoryNotFoundException {
        Category c = categoryRep.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        return c.getProducts().size();
    }

    public int getNumberOfProductsBySubCategory(int subCategoryId) throws SubCategoryNotFoundException {
        SubCategory s = subCategoryRep.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException("SubCategory not found"));
        return s.getProducts().size();
    }

    public int getNumberOfCategories() {
        return (int) categoryRep.count();
    }
}
