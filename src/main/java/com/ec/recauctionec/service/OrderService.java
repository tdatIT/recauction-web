package com.ec.recauctionec.service;

import com.ec.recauctionec.dto.OrderDTO;
import com.ec.recauctionec.entity.Orders;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    List<Orders> findOrderNonConfirm();

    void createOrderNotConfirm(OrderDTO dto);

    boolean confirmOrder(OrderDTO dto);

    boolean cancelOrder(OrderDTO dto);

    boolean completedOrder(OrderDTO dto);
    boolean deliveryOrder(OrderDTO dto);

}
