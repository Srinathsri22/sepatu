package com.example.SepatuOrderEmail.service;

import com.example.SepatuOrderEmail.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
