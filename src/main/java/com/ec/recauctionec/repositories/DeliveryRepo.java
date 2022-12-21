package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery,Integer> {
}
