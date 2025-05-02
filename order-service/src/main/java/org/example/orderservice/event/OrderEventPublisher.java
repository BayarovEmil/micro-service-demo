package org.example.orderservice.event;

import org.example.orderservice.config.OrderRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public OrderEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(String message) {
        rabbitTemplate.convertAndSend(OrderRabbitConfig.EXCHANGE, OrderRabbitConfig.CREATED_ROUTING_KEY, message);
        System.out.println("Order event published::"+message);
    }

    public void cancelOrder(String orderJson) {
        rabbitTemplate.convertAndSend(OrderRabbitConfig.EXCHANGE,OrderRabbitConfig.CANCELLED_ROUTING_KEY, orderJson);
    }
}
