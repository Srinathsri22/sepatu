package com.example.SepatuOrderEmail.controller;

import com.example.SepatuOrderEmail.entity.EmailDetails;
import com.example.SepatuOrderEmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/sendMail")
    public String
    sendMail(EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }
}
