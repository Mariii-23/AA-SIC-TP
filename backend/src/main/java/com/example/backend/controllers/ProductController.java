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
                addProductDTO.getMaterialIds(),
                addProductDTO.getInfos());
    }

    @PostMapping("/category")
    public void addCategory(final @RequestBody AddCategoryDTO addCategoryDTO) {
        productService.addCategory(addCategoryDTO.getName(), addCategoryDTO.getDescription());
    }

    @PostMapping("/subcategory")
    public void addSubCategory(final @RequestBody AddSubCategoryDTO addSubCategoryDTO) {
        productService.addSubCategory(addSubCategoryDTO.getName(), addSubCategoryDTO.getDescription(), addSubCategoryDTO.getCategoryId());
    }

    @PostMapping("/material/add")
    public void addMaterial(final @RequestBody AddMaterialDTO addMaterialDTO) {
        productService.addMaterial(addMaterialDTO.getName(), addMaterialDTO.getImage());
    }

    @PutMapping("/category/add/{productId}/{categoryId}")
    public void addProductToCategory(final @PathVariable int productId, final @PathVariable int categoryId) {
        productService.addProductToCategory(productId, categoryId);
    }

    @PutMapping("/subcategory/add/{productId}/{subCategoryId}")
    public void addProductToSubCategory(final @PathVariable int productId, final @PathVariable int subCategoryId) {
        productService.addProductToSubCategory(productId, subCategoryId);
    }

    @GetMapping("/category/{id}")
    public List<ProductSimpleDTO> getProductsByCategory(@PathVariable int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/subcategory/{id}")
    public List<ProductSimpleDTO> getProductsBySubCategory(@PathVariable int subCategoryId) {
        return productService.getProductsBySubCategory(subCategoryId);
    }

}
