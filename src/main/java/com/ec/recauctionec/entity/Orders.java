package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "auction_sess_id", nullable = false)
    private int auctionSessId;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private double totalPrice;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "delivery_id", nullable = false)
    private int deliveryId;
    @Basic
    @Column(name = "isCompleted", nullable = false)
    private boolean isCompleted;
    @OneToOne(mappedBy = "ordersByOrderId")
    private Commissions commissionsByOrderId;
    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false,insertable = false,updatable = false)
    private Deliveries deliveriesByDeliveryId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAuctionSessId() {
        return auctionSessId;
    }

    public void setAuctionSessId(int auctionSessId) {
        this.auctionSessId = auctionSessId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && auctionSessId == orders.auctionSessId && Double.compare(orders.totalPrice, totalPrice) == 0 && deliveryId == orders.deliveryId && isCompleted == orders.isCompleted && Objects.equals(createDate, orders.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, auctionSessId, totalPrice, createDate, deliveryId, isCompleted);
    }

    public Commissions getCommissionsByOrderId() {
        return commissionsByOrderId;
    }

    public void setCommissionsByOrderId(Commissions commissionsByOrderId) {
        this.commissionsByOrderId = commissionsByOrderId;
    }

    public Deliveries getDeliveriesByDeliveryId() {
        return deliveriesByDeliveryId;
    }

    public void setDeliveriesByDeliveryId(Deliveries deliveriesByDeliveryId) {
        this.deliveriesByDeliveryId = deliveriesByDeliveryId;
    }
}
