package org.example.rentcar.controller;

import org.example.rentcar.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1creative/mail")
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    MessageSenderService messageSenderService;

    @PostMapping("/password-sender/{email}")
    ResponseEntity<String> sendPasswordMessage(@PathVariable String email) {
        messageSenderService.sendSimpleEmail(email);
        return ResponseEntity.ok("Email sent");
    }
}
