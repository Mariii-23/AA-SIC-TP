package com.example.backend.services;

import com.example.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class NotificationService implements INotificationService{
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendNotification(final User user, final String subject, final String message) {
        System.out.println("Sending new price notification to customer: " + user + " with new price: " + message);
        //sendEmail(user.getEmail(), subject, message);
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
