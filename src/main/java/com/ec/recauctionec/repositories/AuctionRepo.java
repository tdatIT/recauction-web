package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.AuctionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AuctionRepo extends JpaRepository<AuctionSession, Integer> {

    @Query("from AuctionSession a where a.isComplete = false and a.userId = ?1")
    List<AuctionSession> findActiveAuction(int userId);

    @Query("select a from AuctionSession a " +
            "where a.isComplete = false " +
            "and date(a.endDate) = :date")
    List<AuctionSession> findAllActiveAuctionByDate(@Param("date") Date date);

    @Query("select a from AuctionSession a" +
            " where a.userId = :userId and (a.startDate<=:date and a.endDate>=:date)")
    List<AuctionSession> findAuctionOfUserAtTime(
            @Param("userId") int userId,
            @Param("date") Date date
    );


}
