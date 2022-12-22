package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.entity.Wallet;
import com.ec.recauctionec.repositories.RoleRepo;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.repositories.VerificationTokenRepo;
import com.ec.recauctionec.service.EmailService;
import com.ec.recauctionec.service.UserService;
import com.ec.recauctionec.variable.RoleConst;
import com.ec.recauctionec.verification.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class
UserServiceImpl implements UserService {

    @Autowired
    VerificationTokenRepo verificationTokenRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    EmailService emailService;

    @Transactional
    @Override
    public User registerAccount(User user) {

        //Create hash password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrypt_pass = encoder.encode(user.getPassword());
        user.setPassword(encrypt_pass);
        user.setRoleId(RoleConst.USER);
        user.setRoleByRoleId(roleRepo.findByRoleId(RoleConst.USER));
        user.setCreateDate(new Date(new java.util.Date().getTime()));
        user.setLevelUser(1);
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken();

        myToken.setToken(token);
        myToken.setUser(user);
        verificationTokenRepo.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return verificationTokenRepo.findByToken(VerificationToken);
    }

    @Override
    public void requestResetPassword(User us) {
        VerificationToken token = verificationTokenRepo.findByUser(us);
        if (token == null) {
            String token_str = UUID.randomUUID().toString();
            token = new VerificationToken();
            token.setUser(us);
            token.setToken(token_str);
            verificationTokenRepo.save(token);
            emailService.sendResetPassword(us, token_str);
        }
    }

    @Override
    public void resetPassword(String token, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrypt_pass = encoder.encode(password);
        VerificationToken verificationToken = verificationTokenRepo.findByToken(token);
        if (verificationToken != null) {
            User us = verificationToken.getUser();
            us.setPassword(encrypt_pass);
            userRepo.save(us);
        }
    }

    @Override
    public void updateConfirmUser(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet);
        user.setWalletsByUserId(wallets);
        userRepo.save(user);
        VerificationToken token = verificationTokenRepo.findByUser(user);
        verificationTokenRepo.delete(token);
    }

    @Override
    public boolean updatePassword(User user, String curPass, String newPass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(curPass, user.getPassword())) {
            String encrypt_pass = encoder.encode(newPass);
            user.setPassword(encrypt_pass);
            userRepo.save(user);
            return true;
        } else
            return false;
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElseThrow();
    }
    @Override
    public List<User> findAllUser() {
        return userRepo.findAllUserNotAdmin();
    }
}
