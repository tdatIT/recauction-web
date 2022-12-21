package com.ec.recauctionec.scheduling;

import com.ec.recauctionec.dto.OrderDTO;
import com.ec.recauctionec.email.EmailDetails;
import com.ec.recauctionec.entity.AuctSessJoin;
import com.ec.recauctionec.entity.AuctionSession;
import com.ec.recauctionec.entity.Orders;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.service.AuctSessJoinService;
import com.ec.recauctionec.service.AuctionService;
import com.ec.recauctionec.service.EmailService;
import com.ec.recauctionec.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Component
public class CheckAuctionScheduledEnd {
    private static final Logger log =
            LoggerFactory.getLogger(CheckAuctionScheduledEnd.class);
    private static final int MIN_SCHEDULED = 10;
    private static final int MIN_NOTIFI = 30;
    private static final int MILLISECOND = 60000;
    private static Calendar calendar;

    @Autowired
    private AuctionService auctionService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OrderService orderService;

    @Scheduled(fixedRate = MIN_SCHEDULED * MILLISECOND)
    public void checkEndTimeAuction() {
        calendar = Calendar.getInstance();
        List<AuctionSession> auctions = auctionService
                .findAllByDate(new Date(new java.util.Date().getTime()));
        for (AuctionSession auction : auctions) {
            if (auction.getEndDate().getTime() >= calendar.getTimeInMillis()) {
                AuctSessJoin win = auctionService.setWinAuctionSession(auction.getAuctionSessId());
                OrderDTO dto = new OrderDTO();
                User us = auction.getUserByUserId();
                dto.setUser(us);
                //set default address
                dto.setAddress(us.getUserAddressesByUserId().iterator().next());
                dto.setProduct(win.getProductByProductId());
                dto.setTotalPrice(win.getPrice());
                dto.setStatus(Orders.NOT_CONFIRM);
                dto.setCreateDate(new Timestamp(new java.util.Date().getTime()));
                orderService.createOrderNotConfirm(dto);
            } else if (auction.getEndDate().getTime() + (MIN_NOTIFI * MILLISECOND) >= calendar.getTimeInMillis()) {
                EmailDetails email = new EmailDetails();
                email.setRecipient(auction.getUserByUserId().getEmail());
                email.setSubject("Phiên Đấu Giá Sắp Kết Thúc");
                email.setMsgBody("Phiên đấu giá ID:[" + auction.getAuctionSessId() +
                        "] của bạn còn 30p nữa là hết hạn]");
                emailService.sendSimpleEmail(email);
            }
        }

    }

    @Scheduled(fixedRate = MIN_NOTIFI * MILLISECOND)
    public void checkConfirmOrder() {
        calendar = Calendar.getInstance();
        List<Orders> orders = orderService.findOrderNonConfirm();
        for (Orders o : orders) {
            OrderDTO dto = new OrderDTO();
            BeanUtils.copyProperties(o, dto);
            orderService.cancelOrder(dto);
        }

    }

}
