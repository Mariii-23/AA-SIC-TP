package com.example.backend.services;

import com.example.backend.model.Customer;
import com.example.backend.model.User;

public interface INotificationService {
    public void sendNotification(User user, String subject, String message);
}
