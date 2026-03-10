package com.notification.notification_service.application.dto;

import com.notification.notification_service.domain.enums.ChannelType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class NotificationResponse {

    private UUID id;

    private String recipient;

    private String message;

    private ChannelType channel;

    private String status;

    private LocalDateTime createdAt;
}