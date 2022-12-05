package com.ec.recauctionec.service;

import com.ec.recauctionec.email.EmailDetails;

public interface EmailService {
    boolean sendSimpleEmail(EmailDetails details);
}
