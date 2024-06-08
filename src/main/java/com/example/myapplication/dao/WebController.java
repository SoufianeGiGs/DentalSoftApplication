package com.example.myapplication.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

@Controller
public class WebController {

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // This will return the contact.html Thymeleaf template
    }

    @PostMapping("/send-message")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@RequestBody ContactForm contactForm) {
        // Process the contact form data here
        // For example, you could save it to a database or send an email

        return ResponseEntity.ok("Message received");
    }

    public static class ContactForm {
        private String name;
        private String email;
        private String message;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}
