package com.example.backend.event;

import com.example.backend.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendUserEmailHandler {
    @Autowired
    private INotificationService notificationService;

    @EventListener
    public void handleSendEmail(final EmailEvent emailEvent) {
        notificationService.sendNewPriceNotification(emailEvent.getCustomer(), emailEvent.getMessage());
    }
}
