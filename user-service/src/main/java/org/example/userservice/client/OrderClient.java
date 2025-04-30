package org.example.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "order-service", url = "http://localhost:8083")
public interface OrderClient {
    @GetMapping("/order")
    String getAllOrders();
}
