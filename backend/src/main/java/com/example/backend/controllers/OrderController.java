package com.example.backend.controllers;

import com.example.backend.dto.CreateOrderDTO;
import com.example.backend.dto.OrderSimpleDTO;
import com.example.backend.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/orders/{costumerId}")
    public List<OrderSimpleDTO> getOrders(@PathVariable int costumerId){
        return orderService.getOrderOfCostumer(costumerId);
    }

    @PostMapping("/order")
    public void createOrder(final @RequestBody CreateOrderDTO order){
        orderService.createOrder(order.getCostumerId(), order.getShoppingCartId(), order.getAddress(), order.isStorePickUp());
    }

}
