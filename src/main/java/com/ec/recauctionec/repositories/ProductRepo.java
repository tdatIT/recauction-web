package com.ec.recauctionec.repositories;


import com.ec.recauctionec.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.supplierId = ?1 and p.isDeleted=false")
    List<Product> findAllBySupplierIdActive(int supplierId);

    List<Product> findAllByProductNameIsLike(String name);

    Product findByProductId(int productId);

}
