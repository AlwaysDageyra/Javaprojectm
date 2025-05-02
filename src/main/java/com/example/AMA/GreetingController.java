package com.example.AMA;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot App!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        String body = "Request was successful.";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "SuccessHeaderValue");
        return ResponseEntity.ok()
                .headers(headers)
                .body(body);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Resource not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        URI location = URI.create("/resource/123");
        return ResponseEntity.created(location).body("Resource created!");
    }



}
