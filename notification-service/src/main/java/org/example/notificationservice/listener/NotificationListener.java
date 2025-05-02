package org.example.notificationservice.listener;

import org.example.notificationservice.config.NotificationRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    @RabbitListener(queues = NotificationRabbitConfig.QUEUE)
    public void handleOrderMessage(String message) {
        System.out.println("📩 Order message received: " + message);
        sendNotification(message);
    }

    public void sendNotification(String order) {
        System.out.println("📢 Sending notification for order: " + order);
    }
}
