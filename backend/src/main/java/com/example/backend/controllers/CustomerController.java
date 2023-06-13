package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/{id}/favourites")
    public EnvelopeDTO<FavouriteDTO> getFavourites(@PathVariable int id, final @RequestBody PaginationDTO paginationDTO) {
        return userService.getFavourites(id, paginationDTO.getOffset(), paginationDTO.getNumItems());
    }

    @GetMapping("/{id}/numberOfFavourites")
    public int getNumberOfFavourites(@PathVariable int id) {
        return userService.getNumberOfFavourites(id);
    }

    @GetMapping("/cart/{id}")
    public ShoppingCartDTO getShoppingCart(@PathVariable int id) {
        return userService.getShoppingCart(id);
    }

    @GetMapping("/orders/{id}")
    public List<OrderSimpleDTO> getOrders(@PathVariable int id) {
        return userService.getOrders(id);
    }

    @PostMapping("/edit/{customer_id}")
    public void editCustomer(final @PathVariable int customer_id, final @RequestBody CustomerDTO costumerDTO) {
        userService.editCustomer(customer_id, costumerDTO);
    }

    @PostMapping("/favourite/add")
    public void addFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        userService.addFavourite(favourite.getCostumerId(), favourite.getProductId());
    }

    @DeleteMapping("/favourite/delete")
    public void deleteFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        userService.deleteFavourite(favourite.getCostumerId(), favourite.getProductId());
    }

    @PostMapping("/password/recover/{customer_id}")
    public String recoverPassword(final @PathVariable int customer_id) {
        return userService.recoverPassword(customer_id);
    }

    @PostMapping("/password/recover/confirm/{customer_id}")
    public boolean confirmRecoverPassword(final @PathVariable int customer_id, final @RequestBody ChangePasswordDTO changePasswordDTO) {
        return userService.confirmRecoverPassword(customer_id, changePasswordDTO.getToken(), changePasswordDTO.getNewPassword());
    }
}
