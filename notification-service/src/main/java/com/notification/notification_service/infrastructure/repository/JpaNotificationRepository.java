package com.notification.notification_service.infrastructure.repository;

import com.notification.notification_service.domain.entity.Notification;
import com.notification.notification_service.domain.repository.NotificationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaNotificationRepository extends JpaRepository<Notification, UUID>, NotificationRepository {
}