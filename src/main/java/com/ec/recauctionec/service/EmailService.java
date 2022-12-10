package com.ec.recauctionec.service;

import com.ec.recauctionec.email.EmailDetails;
import com.ec.recauctionec.entity.User;

public interface EmailService {
    boolean sendSimpleEmail(EmailDetails details);
    boolean sendResetPassword(User us,String token);
}
