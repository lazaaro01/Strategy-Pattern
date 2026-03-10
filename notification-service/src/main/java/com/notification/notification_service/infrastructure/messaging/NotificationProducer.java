package com.notification.notification_service.infrastructure.messaging;

import com.notification.notification_service.domain.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${notification.exchange}")
    private String exchange;

    @Value("${notification.routing-key}")
    private String routingKey;

    public void send(Notification notification) {
        rabbitTemplate.convertAndSend(exchange, routingKey, notification);
    }
}