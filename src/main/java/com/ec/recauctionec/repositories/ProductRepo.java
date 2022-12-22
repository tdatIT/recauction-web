package com.ec.recauctionec.repositories;


import com.ec.recauctionec.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.supplierId = ?1 and p.isDeleted=false")
    List<Product> findAllBySupplierIdActive(int supplierId);

    @Query("select p from  Product p where p.productName like %:name%")
    List<Product> findAllByProductName(String name);

    Product findByProductId(int productId);

    List<Product> findAllByStatus(int status);

    @Query("select p from Product p where p.status = 1 or p.status = 2 order by p.defaultPrice desc")
    List<Product> findProductLimit(Pageable pageable);
}
