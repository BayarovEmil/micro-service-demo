package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice.client.OrderClient;
import org.example.userservice.client.ProductClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
//    private final RestTemplate restTemplate;
    private final ProductClient productClient;
    private final OrderClient orderClient;

    public UserController(ProductClient productClient, OrderClient orderClient) {
        this.productClient = productClient;
        this.orderClient = orderClient;
//        this.restTemplate = new RestTemplate();
    }

    @GetMapping("")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("All users comes");
    }

    @GetMapping("/product-details")
    public ResponseEntity<List<String>> getAllProductDetails() {
//        String productData = restTemplate.getForObject("http://localhost:8082/product", String.class );
//        String orderDetails = restTemplate.getForObject("http://localhost:8083/order", String.class );
        String productData = productClient.getAllProducts();
        String orderDetails = orderClient.getAllOrders();
        return ResponseEntity.ok(
                List.of(
                        productData, orderDetails
                )
        );
    }
}
