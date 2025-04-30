package org.example.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8082")
public interface ProductClient {
    @GetMapping("/product")
    String getAllProducts();
}
