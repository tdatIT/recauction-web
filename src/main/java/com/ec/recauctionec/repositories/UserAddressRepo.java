package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entities.User;
import com.ec.recauctionec.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUser(User user);
}
