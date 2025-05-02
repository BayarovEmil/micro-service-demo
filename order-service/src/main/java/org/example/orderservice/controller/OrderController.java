package org.example.orderservice.controller;

import org.example.orderservice.event.OrderEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderEventPublisher publisher;

    public OrderController(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping
    public ResponseEntity<String> getAllOrders() {
        return ResponseEntity.ok("All orders comes");
    }

    @GetMapping("/send")
    public String createOrder() {
        System.err.println("Send notification");
        publisher.publishOrder("orderJson");
        return "Order created";
    }

    @GetMapping("/cancel")
    public String cancelOrder() {
        System.err.println("Send notification");
        publisher.cancelOrder("Cancelled Order");
        return "Order cancelled";
    }
}
