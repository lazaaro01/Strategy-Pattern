package com.notification.notification_service.application.dto;

import com.notification.notification_service.domain.enums.ChannelType;
import lombok.Data;

@Data
public class NotificationRequest {

    private String recipent;

    private String message;

    private ChannelType channel;
}