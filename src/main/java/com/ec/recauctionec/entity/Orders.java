package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders", schema = "reauction_db")
public class Orders {
    public static final int NOT_CONFIRM = 1;
    public static final int CONFIRM = 2;
    public static final int DELIVERY = 3;
    public static final int COMPLETE = 4;
    public static final int CANCEL = 0;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "updateDate", nullable = false)
    private Date updateDate;
    @Basic
    @Column(name = "delivery_id", nullable = false)
    private int deliveryId;
    @Basic
    @Column(name = "shipping_price", nullable = false, precision = 0)
    private double shippingPrice;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private double totalPrice;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JoinColumn(name = "commission_id", referencedColumnName = "order_id")
    private Commission commission;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false, insertable = false, updatable = false)
    private Delivery deliveryByDeliveryId;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private UserAddress address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "win_auct_id")
    private AuctSessJoin winAuction;
}
