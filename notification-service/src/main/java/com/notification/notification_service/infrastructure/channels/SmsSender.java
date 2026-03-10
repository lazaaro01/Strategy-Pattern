package com.notification.notification_service.infrastructure.channels;

import com.notification.notification_service.domain.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsSender implements NotificationChannel {

    @Override
    public void send(Notification notification) {
        log.info("Sending SMS to {} with message: {}",
                notification.getRecipient(),
                notification.getMessage());
    }
}