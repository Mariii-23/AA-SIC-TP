package com.example.backend.dto;

import com.example.backend.model.Order;
import com.example.backend.model.OrderState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderSimpleDTO {
    private int id;
    private LocalDate date;
    private double total;
    private OrderState state;


    public OrderSimpleDTO() {
    }

    public OrderSimpleDTO(LocalDate date, double total, OrderState state) {
        this.date = date;
        this.total = total;
        this.state = state;
    }

    public OrderSimpleDTO(Order order){
        this.date = order.getDate();
        this.total = order.getTotal();
        this.state = order.getState();
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

}