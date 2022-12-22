package com.ec.recauctionec.service;

import com.ec.recauctionec.entity.Supplier;

public interface SupplierService {
    Supplier findByOwnerId(int ownerId);
    boolean insertNewSupplier(int userId,int location);
}
