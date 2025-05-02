package org.example.notificationservice.listener;

import org.example.notificationservice.config.NotificationRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    @RabbitListener(queues = NotificationRabbitConfig.CREATED_QUEUE)
    public void handleOrderMessage(String message) {
        System.out.println("📩 Order message received: " + message);
        sendNotification(message);
    }

    public void sendNotification(String order) {
        System.out.println("📢 Sending notification for order: " + order);
    }

    @RabbitListener(queues = NotificationRabbitConfig.CANCELLED_QUEUE)
    public void handleCancelMessage(String message) {
        System.out.println("📩 Order message received: " + message);
        sendNotificationSms(message);
    }

    public void sendNotificationSms(String order) {
        System.out.println("📢 Sending SMS notification for order: " + order);
    }


}
