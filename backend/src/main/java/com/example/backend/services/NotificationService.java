package com.example.backend.services;

import com.example.backend.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService{
    @Override
    public void sendNewPriceNotification(final Customer customer, final String message) {
        System.out.println("Sending new price notification to customer: " + customer + " with new price: " + message);
    }
}
