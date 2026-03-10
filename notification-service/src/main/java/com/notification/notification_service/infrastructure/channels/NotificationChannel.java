package com.notification.notification_service.infrastructure.channels;

import com.notification.notification_service.domain.entity.Notification;

public interface NotificationChannel {

    void send(Notification notification);
}