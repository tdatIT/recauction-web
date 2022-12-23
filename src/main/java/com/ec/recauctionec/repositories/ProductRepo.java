package com.ec.recauctionec.repositories;


import com.ec.recauctionec.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Query("select p from Product p where p.isDeleted = false ")
    List<Product> findAllActive();

    @Query("select p from Product p where p.categoryId = ?1")
    List<Product> findByCategoryId(int categoryId);

    @Query("select p from Product p " +
            "where p.supplierBySupplierId.userByOwnerId.userId=:userId" +
            " and p.productTag like %:productTagStr%")
    List<Product> findProductForAuction(@RequestParam("userId") int userId, @RequestParam("productTag") String productTagStr);


}
