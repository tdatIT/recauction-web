package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.Users;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.service.UserService;
import com.ec.recauctionec.variable.RoleConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void registerAccount(Users users) {
        //Create hash password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrypt_pass = encoder.encode(users.getEncryptPassword());
        users.setEncryptPassword(encrypt_pass);
        users.setCreateDate(new Date(new java.util.Date().getTime()));
        users.setLevelUser(1);
        users.setRoleId(RoleConst.USER);
        userRepo.save(users);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void updateUser(Users user) {
        userRepo.save(user);
    }
}
