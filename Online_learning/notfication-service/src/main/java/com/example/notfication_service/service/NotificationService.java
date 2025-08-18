package com.example.notfication_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notfication_service.model.Notification;
import com.example.notfication_service.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Send notification
    public Notification sendNotification(Long userId, String title, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setReadStatus(false);
        notification.setCreatedAt(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    // Get all notifications for a user
    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    // Mark notification as read
    public Notification markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setReadStatus(true);
        return notificationRepository.save(notification);
    }

}