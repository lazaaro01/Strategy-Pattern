package com.notification.notification_service.interfaces.controller;

import com.notification.notification_service.application.dto.NotificationRequest;
import com.notification.notification_service.application.dto.NotificationResponse;
import com.notification.notification_service.application.usecase.SendNotificationUseCase;
import com.notification.notification_service.domain.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final SendNotificationUseCase sendNotificationUseCase;

    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationRequest request) {

        Notification notification = sendNotificationUseCase.execute(request);

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