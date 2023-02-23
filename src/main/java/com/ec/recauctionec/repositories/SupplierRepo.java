package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
    @Query("select s from Supplier s where s.user.userId = ?1")
    Supplier findByOwnerId(int ownerId);

}
