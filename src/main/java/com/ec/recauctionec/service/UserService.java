package com.ec.recauctionec.service;

import com.ec.recauctionec.entity.Users;


public interface UserService {
    Users findByUsername(String username);

    Users findByEmail(String email);

    void registerAccount(Users users);

}
