package com.example.notfication_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.notfication_service.model.Notification;
import com.example.notfication_service.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    
    @PostMapping("/send")
    public Notification sendNotification(@RequestParam Long userId,
                                         @RequestParam String title,
                                         @RequestParam String message) {
        return notificationService.sendNotification(userId, title, message);
    }

    
    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationService.getUserNotifications(userId);
    }

   
    @PutMapping("/read/{id}")
    public Notification markAsRead(@PathVariable Long id) {
        return notificationService.markAsRead(id);
    }
}
