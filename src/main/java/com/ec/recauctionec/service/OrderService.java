package com.ec.recauctionec.service;

import com.ec.recauctionec.dto.OrderDTO;
import com.ec.recauctionec.entity.Orders;

import java.util.Date;
import java.util.List;

public interface OrderService {
    Orders findById(int id);

    List<Orders> findOrderNonConfirm();

    List<Orders> findOrderByDate(int userId, Date date);

    void createOrderNotConfirm(OrderDTO dto);

    boolean confirmOrder(OrderDTO dto);

    boolean cancelOrder(OrderDTO dto);

    boolean completedOrder(OrderDTO dto);

    boolean deliveryOrder(OrderDTO dto);

}
