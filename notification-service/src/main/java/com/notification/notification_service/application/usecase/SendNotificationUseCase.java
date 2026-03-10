package com.notification.notification_service.application.usecase;

import com.notification.notification_service.application.dto.NotificationRequest;
import com.notification.notification_service.domain.entity.Notification;
import com.notification.notification_service.domain.repository.NotificationRepository;
import com.notification.notification_service.infrastructure.messaging.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SendNotificationUseCase {

    private final NotificationRepository repository;
    private final NotificationProducer producer;

    public void execute(NotificationRequest request) {

        Notification notification = Notification.builder()
                .recipient(request.getRecipent())
                .message(request.getMessage())
                .channel(request.getChannel())
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();

        Notification saved = repository.save(notification);

        producer.send(saved);

        return saved;
    }
}