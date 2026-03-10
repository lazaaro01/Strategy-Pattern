package com.notification.notification_service.domain.entity;

import com.notification.notification_service.domain.enums.ChannelType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue
    private UUID id;

    private String recipient;

    private String message;

    @Enumerated(EnumType.STRING)
    private ChannelType channel;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime sentAt;
}