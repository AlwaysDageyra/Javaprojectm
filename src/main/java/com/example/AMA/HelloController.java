package com.example.AMA;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @GetMapping("/ask")
    public String helloMyFriend(Model model) {
        model.addAttribute("message",
                "Do you understand Spring Basics yet?");
        return "index";
    }

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


    @GetMapping("server-error")
    public ResponseEntity<Map<String, String>> getHeaders() {
        HttpHeaders myHeaders = new HttpHeaders();
        myHeaders.add("custom-header", "I am a custom header");

        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "something went wrong");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .headers(myHeaders)
                .body(errorDetails);

    }
}
