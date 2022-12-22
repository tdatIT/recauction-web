package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.Supplier;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.repositories.SupplierRepo;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.service.SupplierService;
import com.ec.recauctionec.variable.RoleConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepo supplierRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Supplier findByOwnerId(int ownerId) {
        return supplierRepo.findByOwnerId(ownerId);
    }

    @Override
    @Transactional
    public boolean insertNewSupplier(int userId, int location) {
        User us = userRepo.findById(userId).orElseThrow();
        if (us != null && us.getRoleId() == RoleConst.USER) {
            Supplier supplier = new Supplier();
            supplier.setActive(true);
            supplier.setLocation(location);
            supplier.setCreateDate(new Date(new java.util.Date().getTime()));
            supplier.setLevelSupp(1);
            supplier.setRating(0);
            us.setRoleId(RoleConst.SUPPLIER);
            supplier.setUserByOwnerId(us);
            //update into db
            supplierRepo.save(supplier);
            userRepo.save(us);
            return true;
        }
        return false;
    }
}
