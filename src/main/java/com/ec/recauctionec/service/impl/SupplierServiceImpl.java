package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entities.AddressData;
import com.ec.recauctionec.entities.Role;
import com.ec.recauctionec.entities.Supplier;
import com.ec.recauctionec.entities.User;
import com.ec.recauctionec.repositories.SupplierRepo;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.service.SupplierService;
import com.ec.recauctionec.variable.RoleConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    public boolean insertNewSupplier(User user, AddressData address) {
        if (user != null && user.getRole().getRoleId() == RoleConst.USER) {
            Supplier supplier = new Supplier();
            supplier.setActive(true);
            supplier.setCreateDate(new Date(new java.util.Date().getTime()));
            supplier.setLevelSupp(1);
            supplier.setRating(0);
            List<AddressData> dataList = new ArrayList<>();
            address.setSupplier(supplier);
            dataList.add(address);
            supplier.setAddresses(dataList);
            supplier.setUser(user);
            //update into db
            supplierRepo.save(supplier);
            user.setRole(new Role(Role.ROLE_SUPPLIER));
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
