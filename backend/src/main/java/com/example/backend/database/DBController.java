package com.example.backend.database;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/db")
public class DBController {
    @Resource(name = "dbService")
    private DBService dbService;

    @PostMapping("/addUsers")
    public void addUsers() {
        dbService.addUsers();
    }

    @PostMapping("/addMaterials")
    public void addMaterials() {
        dbService.addMaterials();
    }

    @PostMapping("/addCategories")
    public void addCategories() {
        dbService.addCategories();
    }

    @PostMapping("/addSubcategories")
    public void addSubcategories() {
        dbService.addSubcategories();
    }

    @PostMapping("/addProducts")
    public void addProducts() {
        dbService.addProducts();
    }

    @PostMapping("/addImages")
    public void addImages() {
        dbService.addImages();
    }

    @PostMapping("/addOrders")
    public void addOrders() {
        dbService.addOrders();
    }
/*
    @PostMapping("/addFavourites")
    public void addFavourites() {
        dbService.addFavourites();
    }
 */

    @PostMapping("/all")
    public void addAll(){
        dbService.addUsers();
        dbService.addMaterials();
        dbService.addCategories();
        dbService.addSubcategories();
        dbService.addProducts();
        dbService.addImages();
        dbService.addOrders();
        //dbService.addFavourites();
    }

}
