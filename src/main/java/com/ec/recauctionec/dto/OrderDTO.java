package com.ec.recauctionec.dto;

import com.ec.recauctionec.entity.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
public class OrderDTO {

    private int orderId;
    @NotNull
    private Timestamp createDate;

    private Date updateDate;

    private int deliveryId;

    private double shippingPrice;
    @NotNull
    private int status;
    @NotNull
    private double totalPrice;

    private AuctSessJoin winAuction;

    private Delivery deliveryByDeliveryId;

    private Product product;

    private UserAddress address;
    @NotNull
    private User user;

    private Commission commission;

    public Orders mapping() {
        Orders order = new Orders();
        BeanUtils.copyProperties(this, order);
        return order;
    }
}
