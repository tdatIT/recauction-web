package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<Users, Integer> {
    @Query(value = "select u from Users u where u.username = ?1 and u.encryptPassword=?2")
    Users validateAccount(String username, String password);

    @Query(value = "select u from Users u where u.username=?1")
    Users findByUsername(String username);

    @Query(value = "select u from Users u where u.email = ?1")
    Users findByEmail(String email);
}
