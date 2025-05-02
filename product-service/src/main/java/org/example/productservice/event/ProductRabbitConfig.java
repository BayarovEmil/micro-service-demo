package org.example.productservice.event;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductRabbitConfig {
    public static final String EXCHANGE = "orderExchange";

    public static final String DECREASE_STOCK_QUEUE = "order.update.queue";
    public static final String DECREASE_STOCK_ROUTING = "order.update";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue decreaseStockCount() {
        return new Queue(DECREASE_STOCK_QUEUE, false);
    }

    @Bean
    public Binding decreaseStockBinding(Queue decreaseStockCount, DirectExchange exchange) {
        return BindingBuilder
                .bind(decreaseStockCount)
                .to(exchange)
                .with(DECREASE_STOCK_ROUTING);
    }
}
