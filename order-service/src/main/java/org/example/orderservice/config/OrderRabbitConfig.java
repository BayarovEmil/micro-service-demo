package org.example.orderservice.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRabbitConfig {
    public static final String EXCHANGE = "orderExchange";

    public static final String CREATED_ROUTING_KEY = "order.created";
    public static final String CANCELLED_ROUTING_KEY = "order.cancelled";
    public static final String DECREASED_ROUTING_KEY = "order.update";


    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(EXCHANGE);
    }
}
