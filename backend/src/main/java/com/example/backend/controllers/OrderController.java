package com.example.backend.controllers;

import com.example.backend.Exception.ItemNotFoundException;
import com.example.backend.Exception.OrderNotFoundException;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.dto.*;
import com.example.backend.model.OrderState;
import com.example.backend.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/customer/orders/{costumerId}")
    public List<OrderSimpleDTO> getOrders(@PathVariable int costumerId){
        try {
            return orderService.getOrdersOfCostumer(costumerId);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/customer/order/{orderId}")
    public OrderDetailedDTO getOrder(@PathVariable int orderId){
        try {
            return orderService.getOrder(orderId);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/customer/numberOfOrders/{id}")
    public int getNumberOfOrders(@PathVariable int id) {
        try {
            return orderService.getNumberOfOrders(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/admin/orders")
    public List<OrderSimpleDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/admin/ready/{orderId}")
    public boolean setOrderReady(@PathVariable int orderId){
        try {
            return orderService.setOrderState(orderId, OrderState.READY);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/admin/done/{orderId}")
    public boolean setOrderDone(@PathVariable int orderId){
        try {
            return orderService.setOrderState(orderId, OrderState.DONE);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/create")
    public void createOrder(final @RequestBody CreateOrderDTO order){
        try {
            orderService.createOrder(order.getCostumerId(), order.getAddress(), order.isStorePickUp());
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/shoppingCart/product")
    public void addProductToShoppingCart(final @RequestBody AddProductToShoppingCartDTO product){
        try {
            orderService.addProductToShoppingCart(product.getCostumerId(),
                                                  product.getProductId(),
                                                  product.getMaterialId(),
                                                  product.getQuantity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/shoppingCart/quantity")
    public void setProductQuantityInShoppingCart(final @RequestBody SetProductQuantityDTO product){
        try {
            orderService.setProductQuantity(product.getItemId(), product.getQuantity());
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/customer/shoppingCart/product/{itemId}")
    public void deleteProductFromShoppingCart(@PathVariable int itemId){
        try {
            orderService.deleteItemFromShoppingCart(itemId);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



}
