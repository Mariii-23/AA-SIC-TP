package com.example.backend.services;

import com.example.backend.model.Customer;

import java.util.List;

public interface INotificationService {
    public void sendNewPriceNotification(Customer customer, String message);
}
