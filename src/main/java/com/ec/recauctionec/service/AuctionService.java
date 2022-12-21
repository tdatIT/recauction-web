package com.ec.recauctionec.service;

import com.ec.recauctionec.dto.AuctionSessionDTO;
import com.ec.recauctionec.entity.AuctSessJoin;
import com.ec.recauctionec.entity.AuctionSession;
import com.ec.recauctionec.entity.User;

import java.sql.Date;
import java.util.List;

public interface AuctionService {

    AuctionSession findById(int id);

    List<AuctionSession> findAllByDate(Date date);

    List<AuctionSession> findAllByUserAndActive(int userId, Date dateFilter);

    boolean createNewAuction(User us, AuctionSessionDTO dto);

    AuctSessJoin setWinAuctionSession(int auctionId);

    boolean cancelAuction(int auctionId);
}
