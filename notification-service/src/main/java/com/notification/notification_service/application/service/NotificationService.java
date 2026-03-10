package com.notification.notification_service.application.service;

import com.notification.notification_service.application.dto.NotificationRequest;
import com.notification.notification_service.application.dto.NotificationResponse;
import com.notification.notification_service.application.usecase.SendNotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final SendNotificationUseCase sendNotificationUseCase;

    public NotificationResponse send(NotificationRequest request) {

        var notification = sendNotificationUseCase.execute(request);

        return NotificationResponse.builder()
                .id(notification.getId())
                .recipient(notification.getRecipient())
                .message(notification.getMessage())
                .channel(notification.getChannel())
                .status(notification.getStatus())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}