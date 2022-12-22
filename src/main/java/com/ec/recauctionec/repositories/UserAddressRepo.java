package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUserByUserId(User user);
}
