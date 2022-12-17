package com.ec.recauctionec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "auc_win_id", nullable = false)
    private long aucWinId;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "delivery_id", nullable = false)
    private int deliveryId;
    @Basic
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Basic
    @Column(name = "shipping_price", nullable = false, precision = 0)
    private double shippingPrice;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private double totalPrice;
    @OneToOne(mappedBy = "ordersByOrderId")
    private Commission commissionByOrderId;
    @ManyToOne
    @JoinColumn(name = "auc_win_id", referencedColumnName = "id", nullable = false,
            insertable = false, updatable = false)
    private AuctSessJoin auctSessJoinByAucWinId;
    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false,
            insertable = false, updatable = false
    )
    private Delivery deliveryByDeliveryId;


}
