package org.example.userservice.events.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRabbitConfig {
    public static final String EXCHANGE ="notificationExchange";
    public static final String NOTIFICATION_ROUTING = "notification.send";
    public static final String NOTIFICATION_QUEUE = "notification.send.queue";

    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE);
    }

    @Bean
    public DirectExchange userExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue notificationQueue, DirectExchange userExchange) {
        return BindingBuilder.bind(notificationQueue).to(userExchange).with(NOTIFICATION_ROUTING);
    }
}
