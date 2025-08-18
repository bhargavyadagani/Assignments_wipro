package com.example.notfication_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notfication_service.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);

}
