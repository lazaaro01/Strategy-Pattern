package com.notification.notification_service.infrastructure.channels;

import com.notification.notification_service.domain.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailSender implements NotificationChannel{

    @Override
    public void send(Notification notification) {
        log.info("Sending EMAIL to {} with message: {}",
                notification.getRecipient(),
                notification.getMessage());
    }
}