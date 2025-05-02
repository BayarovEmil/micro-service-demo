package org.example.productservice.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductListener {

    @RabbitListener(queues = ProductRabbitConfig.DECREASE_STOCK_QUEUE)
    public void decreaseListener(String message) {
        System.out.println("Done");
        decreaseProductCount(message);
    }

    public void decreaseProductCount(String message) {
        System.out.println("Product count decreased");
    }
}
