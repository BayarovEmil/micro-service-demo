package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RestTemplate restTemplate;

    public UserController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("All users comes");
    }

    @GetMapping("/product-details")
    public ResponseEntity<List<String>> getAllProductDetails() {
        String productData = restTemplate.getForObject("http://localhost:8082/product", String.class );
        String orderDetails = restTemplate.getForObject("http://localhost:8083/order", String.class );
        return ResponseEntity.ok(
                List.of(
                        productData, orderDetails
                )
        );
    }
}
