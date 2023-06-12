package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerbyId(@PathVariable int id) {
        return userService.getCustomerById(id);
    }

    @GetMapping("/customer/all")
    public List<CustomerDTO> getAllCustumers() {
        return userService.getAllCustomers();
    }

    @GetMapping("/admin/{id}")
    public AdminDTO getAdminbyId(@PathVariable int id) {
        return userService.getAdminById(id);
    }

    @GetMapping("/admin/all")
    public List<AdminDTO> getAllAdmins() {
        return userService.getAllAdmins();
    }

    @GetMapping("/customer/{id}/favourites")
    public List<FavouriteDTO> getFavourites(@PathVariable int id) {
        return userService.getFavourites(id);
    }

    @GetMapping("/customer/{id}/cart")
    public ShoppingCartDTO getShoppingCart(@PathVariable int id) {
        return userService.getShoppingCart(id);
    }

    @GetMapping("/customer/{id}/orders")
    public List<OrderSimpleDTO> getOrders(@PathVariable int id) {
        return userService.getOrders(id);
    }

    @PostMapping("/admin")
    public void addAdmin(final @RequestBody AdminDTO admin) {
        userService.addAdminDTO(admin);
    }

  
    @DeleteMapping("/admin/remove/{id}")
    public void removeAdmin(@PathVariable int id) {userService.removeAdmin(id);}

    @PostMapping("/customer/edit/{customer_id}")
    public void editCustomer(final @PathVariable int customer_id, final @RequestBody CustomerDTO costumerDTO) {
        userService.editCustomer(customer_id, costumerDTO);
    }

    @PostMapping("/admin/edit/{admin_id}")
    public void editAdmin(final @PathVariable int admin_id, final @RequestBody AdminDTO adminDTO) {
        userService.editAdmin(admin_id, adminDTO);
    }

    @PostMapping("/logout")
    public boolean logout(@RequestParam String token) {
        return userService.logout(token);
    }

    @PostMapping("/favourite/add")
    public void addFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        userService.addFavourite(favourite.getCostumerId(), favourite.getProductId());
    }

    @DeleteMapping("/favourite/delete")
    public void deleteFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        userService.deleteFavourite(favourite.getCostumerId(), favourite.getProductId());
    }

}
