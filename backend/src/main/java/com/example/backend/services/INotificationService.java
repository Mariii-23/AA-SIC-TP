package com.example.backend.services;

import com.example.backend.model.User;

public interface INotificationService {
    void sendNotification(User user, String subject, String message);
}
