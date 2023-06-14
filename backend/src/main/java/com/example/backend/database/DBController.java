package com.example.backend.database;

import com.example.backend.exception.UserNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/db")
public class DBController {
    @Resource(name = "dbService")
    private DBService dbService;

    @PostMapping("/addUsers")
    public void addUsers() {
        try {
            dbService.addUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addCompany")
    public void addCompany() {
        dbService.addCompany();
    }

    @PostMapping("/addSocialNetworks")
    public void addSocialNetworks() {
        dbService.addSocialNetworks();
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
    public void addOrders() throws UserNotFoundException {
        dbService.addOrders();
    }

    @PostMapping("/addItems")
    public void addItems() throws Exception {
        dbService.addItems();
    }

    @PostMapping("/addFavourites")
    public void addFavourites() {
        dbService.addFavourites();
    }

    @PostMapping("/addMoreOrders")
    public void addMoreOrders() throws Exception {
        dbService.addMoreOrders();
    }

    @PostMapping("/all")
    public void addAll() throws Exception {
        dbService.addUsers();
        dbService.addCompany();
        dbService.addSocialNetworks();
        dbService.addMaterials();
        dbService.addCategories();
        dbService.addSubcategories();
        dbService.addProducts();
        dbService.addFavourites();
        dbService.addImages();
        dbService.addItems();
        dbService.addOrders();
        dbService.addMoreOrders();
    }

}
