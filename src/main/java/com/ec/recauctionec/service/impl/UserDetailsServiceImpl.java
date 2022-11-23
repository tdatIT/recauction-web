package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.CustomUserDetails;
import com.ec.recauctionec.entity.Users;
import com.ec.recauctionec.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found");
        }
        return new CustomUserDetails(user);
    }
}
