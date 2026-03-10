package com.notification.notification_service.infrastructure.messaging;

import com.notification.notification_service.domain.entity.Notification;
import com.notification.notification_service.infrastructure.channels.NotificationChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final Map<String, NotificationChannel> channels;

    @RabbitListener(queues = "${notification.queue}")
    public void consume(Notification notification) {

        NotificationChannel channel =
                channels.get(notification.getChannel().name().toLowerCase() + "Sender");

        if (channel != null) {
            channel.send(notification);
        }
    }
}