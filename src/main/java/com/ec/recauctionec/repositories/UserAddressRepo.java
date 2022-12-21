package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepo extends JpaRepository<UserAddress,Integer> {
}
