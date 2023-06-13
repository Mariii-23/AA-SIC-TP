package com.example.backend.event;

import com.example.backend.model.Customer;
import com.example.backend.model.User;
import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
    private User user;
    private String subject;
    private String message;

    public EmailEvent(Object source, User user, String subject, String message) {
        super(source);
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
