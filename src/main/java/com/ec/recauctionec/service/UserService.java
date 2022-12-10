package com.ec.recauctionec.service;

import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.verification.VerificationToken;


public interface UserService {
    User findByUsername(String username);

    User findByEmail(String email);

    User registerAccount(User users);

    void updateUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    void requestResetPassword(User us);

    void resetPassword(String token, String password);
    void updateConfirmUser(User user);
}
