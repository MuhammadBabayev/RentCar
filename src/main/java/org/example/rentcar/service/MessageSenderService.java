package org.example.rentcar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("SALAM");
        message.setText("SIFRENIZ:DSKLADK");
        message.setFrom("1creativecars@gmail.com");
        mailSender.send(message);
    }
}
