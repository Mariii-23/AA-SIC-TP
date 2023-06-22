package com.example.backend.database;

import com.example.backend.exception.UserNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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
        try {
            dbService.addCompany();
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }

    @PostMapping("/addSocialNetworks")
    public void addSocialNetworks() {
        dbService.addSocialNetworks();
    }

    @PostMapping("/addMaterials")
    public void addMaterials() {
        try {
            dbService.addMaterials();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addCategories")
    public void addCategories() {
        try {
            dbService.addCategories();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addSubcategories")
    public void addSubcategories() {
        try {
            dbService.addSubcategories();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addProducts")
    public void addProducts() {
        try {
            dbService.addProducts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addImages")
    public void addImages() {
        try {
            dbService.addImages();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addOrders")
    public void addOrders() throws UserNotFoundException {
        try {
            dbService.addOrders();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    @PostMapping("/addInfos")
    public void addInfos() throws Exception {
        dbService.addInfos();
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
        dbService.addInfos();
        dbService.addFavourites();
        dbService.addImages();
        dbService.addItems();
        dbService.addOrders();
        dbService.addMoreOrders();

    }

}