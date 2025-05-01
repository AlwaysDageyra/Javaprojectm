package com.example.AMA;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/demo")
public class ResponseDemoController {

    @GetMapping("/ok")
    public ResponseEntity<String> getOk() {
        // body details.
        String details = "I am the body of the OK status code";
        return ResponseEntity.ok(details);
}

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Resource not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        URI location = URI.create("/resource/123");
        return ResponseEntity.created(location)
                .body("Resource created!");
    }
}
