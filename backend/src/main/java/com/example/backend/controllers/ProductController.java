package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.services.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(final @RequestBody AddProductDTO addProductDTO) {
        productService.addProduct(addProductDTO.getName(),
                addProductDTO.getDescription(),
                addProductDTO.getPrice(),
                addProductDTO.getCategoryId(),
                addProductDTO.getSubCategoryId(),
                addProductDTO.getMaterialIds(),
                addProductDTO.getInfos(),
                addProductDTO.getImages());
    }

    @DeleteMapping("/remove/{productId}")
    public void removeProduct(final @PathVariable int productId) {
        productService.removeProduct(productId);
    }

    @PostMapping("/edit/{productId}")
    public void editProductSimple(final @PathVariable int productId, final @RequestBody EditProductDTO editProductDTO) {
        productService.editProduct(productId,
                editProductDTO.getName(),
                editProductDTO.getDescription(),
                editProductDTO.getPrice(),
                editProductDTO.getCategoryId(),
                editProductDTO.getSubCategoryId(),
                editProductDTO.getMaterialIds(),
                editProductDTO.getInfos());
    }

    @PostMapping("/edit/addimages/{productId}")
    public void addProductImages(final @PathVariable int productId, final @RequestBody List<String> images) {
        productService.addProductImages(productId, images);
    }

    @PostMapping("/edit/removeimages/{productId}")
    public void removeProductImages(final @PathVariable int productId, final @RequestBody List<String> images) {
        productService.removeProductImages(productId, images);
    }


    @PostMapping("/category")
    public void addCategory(final @RequestBody AddCategoryDTO addCategoryDTO) {
        productService.addCategory(addCategoryDTO.getName(), addCategoryDTO.getImage());
    }

    @PostMapping("/category/edit/{categoryId}")
    public void editCategory(final @PathVariable int categoryId, final @RequestBody EditCategoryDTO addCategoryDTO) {
        productService.editCategory(categoryId, addCategoryDTO.getName(), addCategoryDTO.getImage());
    }

    @DeleteMapping("/category/remove/{categoryId}")
    public boolean removeCategory(final @PathVariable int categoryId) {
        return productService.removeCategory(categoryId);
    }

    @PostMapping("/subcategory")
    public void addSubCategory(final @RequestBody AddSubCategoryDTO addSubCategoryDTO) {
        productService.addSubCategory(addSubCategoryDTO.getName(), addSubCategoryDTO.getImage(), addSubCategoryDTO.getCategoryId());
    }

    @PostMapping("/subcategory/edit")
    public void editSubCategories(final @RequestBody EditSubCategoriesDTO editSubCategoriesDTO) {
        productService.editSubCategories(editSubCategoriesDTO.getSubCategories());
    }

    @DeleteMapping("/subcategory/remove/{subCategoryId}")
    public void removeSubCategory(final @PathVariable int subCategoryId) {
        productService.removeSubCategory(subCategoryId);
    }

    @PostMapping("/material/add")
    public void addMaterial(final @RequestBody AddMaterialDTO addMaterialDTO) {
        productService.addMaterial(addMaterialDTO.getName(), addMaterialDTO.getImage());
    }

    @PostMapping("/category/add/{productId}/{categoryId}")
    public void addProductToCategory(final @PathVariable int productId, final @PathVariable int categoryId) {
        productService.addProductToCategory(productId, categoryId);
    }

    @PostMapping("/subcategory/add/{productId}/{subCategoryId}")
    public void addProductToSubCategory(final @PathVariable int productId, final @PathVariable int subCategoryId) {
        productService.addProductToSubCategory(productId, subCategoryId);
    }

    @GetMapping("all/category/{categoryId}")
    public List<ProductSimpleDTO> getProductsByCategory(@PathVariable int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("all/subcategory/{subCategoryId}")
    public List<ProductSimpleDTO> getProductsBySubCategory(@PathVariable int subCategoryId) {
        return productService.getProductsBySubCategory(subCategoryId);
    }

    @GetMapping("all/{productId}")
    public ProductDetailedDTO getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("all//categories")
    public List<CategoryDTO> getAllCategories() {
        return productService.getAllCategories();
    }

    @PostMapping("/review")
    public void addReview(final @RequestBody AddReviewDTO addReviewDTO) {
        productService.addReview(addReviewDTO.getCustomerId(), addReviewDTO.getProductId(), addReviewDTO.getClassification(), addReviewDTO.getComment());
    }

}
