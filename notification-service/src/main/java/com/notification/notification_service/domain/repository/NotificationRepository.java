package com.notification.notification_service.domain.repository;

import com.notification.notification_service.domain.entity.Notification;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository {

    Notification save(Notification notification);

    Optional<Notification> findById(UUID id);
}