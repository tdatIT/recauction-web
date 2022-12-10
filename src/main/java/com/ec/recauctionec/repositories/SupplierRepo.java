package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
    Supplier findByOwnerId(int ownerId);

}
