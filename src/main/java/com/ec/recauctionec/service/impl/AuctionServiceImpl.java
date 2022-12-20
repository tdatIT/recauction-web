package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.dto.AuctionSessionDTO;
import com.ec.recauctionec.entity.AuctionImg;
import com.ec.recauctionec.entity.AuctionSession;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.entity.Wallet;
import com.ec.recauctionec.repositories.AuctionRepo;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.repositories.WalletRepo;
import com.ec.recauctionec.service.AuctionService;
import com.ec.recauctionec.service.StorageImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    public final static double CHECK_AVAILABLE = 0.3D;
    public final static int CHECK_TOTAL_AUCTION = 5;

    @Autowired
    private AuctionRepo auctionRepo;
    @Autowired
    private UserRepo user;
    @Autowired
    private WalletRepo walletRepo;
    @Autowired
    private StorageImage storageImage;

    @Override
    public AuctionSession findById(int id) {
        return auctionRepo.getById(id);
    }

    @Override
    public List<AuctionSession> findAllByDate(Date date) {
        return auctionRepo.findAllActiveAuctionByDate(date);
    }

    @Override
    public List<AuctionSession> findAllByUserAndActive(int userId, Date date) {
        return auctionRepo.findAuctionOfUserAtTime(userId, date);
    }

    @Override
    @Transactional
    public boolean createNewAuction(User us, AuctionSessionDTO dto) {
        boolean status = false;
        try {
            AuctionSession auction = dto.mapping();
            Wallet w_us = walletRepo.findByUserId(us.getUserId()).get(0);
            if (w_us.getAccountBalance() >= (dto.getReservePrice() * CHECK_AVAILABLE)
                    && auctionRepo.findActiveAuction(us.getUserId()).size() < CHECK_TOTAL_AUCTION) {
                auction.setUserId(us.getUserId());
                if (dto.isAuto()) {
                    //business logic process
                }
                if (dto.getImg() != null) {
                    List<AuctionImg> imgs = new ArrayList<>();
                    List<String> filenames = storageImage.storageMultiImage(dto.getImg());
                    for (String name : filenames) {
                        AuctionImg img = new AuctionImg();
                        img.setImageFile(name);
                        img.setAuction(auction);
                        imgs.add(img);
                    }
                    auction.setImg(imgs);
                }

                auctionRepo.save(auction);
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    @Transactional
    public boolean cancelAuction(AuctionSessionDTO dto) {
        return true;
    }
}