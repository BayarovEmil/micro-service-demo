package org.example.notificationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationRabbitConfig {
    public static final String EXCHANGE = "orderExchange";

    public static final String CREATED_QUEUE = "order.created.queue";
    public static final String CREATED_ROUTING_KEY = "order.created";
    public static final String CANCELLED_QUEUE = "order.cancelled.queue";
    public static final String CANCELLED_ROUTING_KEY = "order.cancelled";

    @Bean
    public Queue createdQueue() {
        return new Queue(CREATED_QUEUE, false);
    }

    @Bean
    public Queue cancelledQueue() {
        return new Queue(CANCELLED_QUEUE, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingCreated(Queue createdQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(createdQueue)
                .to(exchange)
                .with(CREATED_ROUTING_KEY);
    }

    @Bean
    public Binding bindingCancelled(Queue cancelledQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(cancelledQueue)
                .to(exchange)
                .with(CANCELLED_ROUTING_KEY);
    }
}
