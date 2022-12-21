package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
    @Query("select o from Orders o " +
            "where o.status = 1 " +
            "and o.createDate >= :check")
        //NOT_CONFIRM = 1
    List<Orders> findByNonConfirm(@Param("check") Timestamp check);
}
