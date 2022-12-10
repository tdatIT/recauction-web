package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.Supplier;
import com.ec.recauctionec.repositories.SupplierRepo;
import com.ec.recauctionec.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepo supplierRepo;

    @Override
    public Supplier findByOwnerId(int ownerId) {
        return supplierRepo.findByOwnerId(ownerId);
    }
}
