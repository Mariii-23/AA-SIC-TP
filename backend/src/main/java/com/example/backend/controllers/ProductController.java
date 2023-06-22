package com.example.backend.controllers;

import com.example.backend.dto.productDTOs.*;
import com.example.backend.exception.*;
import com.example.backend.dto.*;
import com.example.backend.services.ProductService;
import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @PostMapping("/add")
    public ProductSimpleDTO addProduct(final @RequestBody AddProductDTO addProductDTO) {
        try {
            return productService.addProduct(addProductDTO.getName(),
                    addProductDTO.getDescription(),
                    addProductDTO.getPrice(),
                    addProductDTO.getCategoryId(),
                    addProductDTO.getSubCategoryId(),
                    addProductDTO.getMaterialIds(),
                    addProductDTO.getInfos(),
                    addProductDTO.getImages());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/remove/{productId}")
    public void removeProduct(final @PathVariable int productId) {
        try {
            productService.removeProduct(productId);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/edit/{productId}")
    public ProductSimpleDTO editProductSimple(final @PathVariable int productId, final @RequestBody EditProductDTO editProductDTO) {
        try {
            return productService.editProduct(productId,
                    editProductDTO.getName(),
                    editProductDTO.getDescription(),
                    editProductDTO.getPrice(),
                    editProductDTO.getCategoryId(),
                    editProductDTO.getSubCategoryId(),
                    editProductDTO.getMaterialIds(),
                    editProductDTO.getInfos());
        } catch (ProductNotFoundException | CategoryNotFoundException | SubCategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/edit/addimages/{productId}")
    public void addProductImages(final @PathVariable int productId, final @RequestBody List<byte[]> images) {
        try {
            productService.addProductImages(productId, images);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/edit/removeimages/{productId}")
    public void removeProductImages(final @PathVariable int productId, final @RequestBody List<byte[]> images) {
        productService.removeProductImages(productId, images);
    }


    @PostMapping("/category")
    public CategoryDTO addCategory(final @RequestBody AddCategoryDTO addCategoryDTO) {
        return productService.addCategory(addCategoryDTO.getName(), addCategoryDTO.getImage());
    }

    @PostMapping("/category/edit/{categoryId}")
    public CategoryDTO editCategory(final @PathVariable int categoryId, final @RequestBody EditCategoryDTO editCategoryDTO) {
        try {
            return productService.editCategory(categoryId, editCategoryDTO.getName(), editCategoryDTO.getImage());
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/category/remove/{categoryId}")
    public boolean removeCategory(final @PathVariable int categoryId) {
        try {
            return productService.removeCategory(categoryId);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/subcategory")
    public SubCategoryDTO addSubCategory(final @RequestBody AddSubCategoryDTO addSubCategoryDTO) {
        return productService.addSubCategory(addSubCategoryDTO.getName(), addSubCategoryDTO.getImage(), addSubCategoryDTO.getCategoryId());
    }

    @PostMapping("/subcategory/edit")
    public void editSubCategories(final @RequestBody EditSubCategoriesDTO editSubCategoriesDTO) {
        try {
            productService.editSubCategories(editSubCategoriesDTO.getSubCategories());
        } catch (SubCategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/subcategory/remove/{subCategoryId}")
    public void removeSubCategory(final @PathVariable int subCategoryId) {
        try {
            productService.removeSubCategory(subCategoryId);
        } catch (SubCategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/material/add")
    public MaterialDTO addMaterial(final @RequestBody AddMaterialDTO addMaterialDTO) {
        try {
            return productService.addMaterial(addMaterialDTO.getName(), addMaterialDTO.getImage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/material/edit")
    public MaterialDTO editMaterial(final @RequestBody EditMaterialDTO materialDTO) {
        try {
            return productService.editMaterial(materialDTO.getId(), materialDTO.getName(), materialDTO.getImage());
        } catch (MaterialNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/material/remove/{materialId}")
    public void removeMaterial(final @PathVariable int materialId) {
        try {
            productService.removeMaterial(materialId);
        } catch (MaterialNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/category/add/{productId}/{categoryId}")
    public void addProductToCategory(final @PathVariable int productId, final @PathVariable int categoryId) {
        try {
            productService.addProductToCategory(productId, categoryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/subcategory/add/{productId}/{subCategoryId}")
    public void addProductToSubCategory(final @PathVariable int productId, final @PathVariable int subCategoryId) {
        try {
            productService.addProductToSubCategory(productId, subCategoryId);
        } catch (SubCategoryNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/category/numberOfProducts")
    public int getNumberOfProductsByCategory(final @RequestParam int categoryId) {
        try {
            return productService.getNumberOfProductsByCategory(categoryId);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all/category")
    public EnvelopeDTO<ProductSimpleDTO> getProductsByCategory(final @RequestParam int categoryId, final @RequestParam int offset, final @RequestParam int numItems) {
        try {
            return productService.getProductsByCategory(categoryId, offset, numItems);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/subcategory/numberOfProducts")
    public int getNumberOfProductsBySubCategory(final @RequestParam int subCategoryId) {
        try {
            return productService.getNumberOfProductsBySubCategory(subCategoryId);
        } catch (SubCategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all/subcategory")
    public EnvelopeDTO<ProductSimpleDTO> getProductsBySubCategory(final @RequestParam int subCategoryId, final @RequestParam int offset, final @RequestParam int numItems) {
        try {
            return productService.getProductsBySubCategory(subCategoryId, offset, numItems);
        } catch (SubCategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all")
    public ProductDetailedDTO getProductById(final @RequestParam int productId) {
        try {
            return productService.getProductById(productId);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/all/productImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> productImage(final @RequestParam int imageId) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(productService.getProductImage(imageId)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/all/categoryImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> categoryImage(final @RequestParam int categoryId) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(productService.getCategoryImage(categoryId)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/all/subcategoryImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> subcategoryImage(final @RequestParam int subCategoryId) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(productService.getSubCategoryImage(subCategoryId)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/all/materialImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> materialImage(final @RequestParam int materialId) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(productService.getMaterialImage(materialId)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/category/numberOfCategories")
    public int getNumberOfCategories() {
        return productService.getNumberOfCategories();
    }

    @GetMapping("/all/categories")
    public EnvelopeDTO<CategoryDTO> getAllCategories(final @RequestParam int offset, final @RequestParam int numItems) {
        return productService.getAllCategories(offset, numItems);
    }

    @GetMapping("/allMaterials")
    public EnvelopeDTO<MaterialDTO> getAllMaterials(final @RequestParam int offset, final @RequestParam int numItems) {
        return productService.getAllMaterials(offset, numItems);
    }

    @GetMapping("/all/numberOfMaterials")
    public int getNumberOfMaterials() {
        return productService.getNumberOfMaterials();
    }

    @GetMapping("/all/products")
    public EnvelopeDTO<ProductSimpleDTO> getAllProducts(final @RequestParam int offset, final @RequestParam int numItems) {
        return productService.getAllProducts(offset, numItems);
    }

    @GetMapping("/all/numberOfProducts")
    public int getNumberOfProducts() {
        return productService.getNumberOfProducts();
    }

    @PostMapping("/review")
    public void addReview(final @RequestBody AddReviewDTO addReviewDTO) {
        try {
            productService.addReview(addReviewDTO.getCustomerId(), addReviewDTO.getProductId(), addReviewDTO.getClassification(), addReviewDTO.getComment());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
