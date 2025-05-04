package org.example.userservice.events.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    @RabbitListener(queues = UserRabbitConfig.NOTIFICATION_QUEUE)
    public void sendUserNotification(String message) {
        sendMessage(message);
    }

    private void sendMessage(String message) {
        System.out.println("Message sended to user::" +message);
    }
}
