package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Commissions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "commission_value", nullable = false, precision = 0)
    private double commissionValue;
    @Basic
    @Column(name = "profit", nullable = false, precision = 0)
    private double profit;
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false,insertable = false,updatable = false)
    private Orders ordersByOrderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getCommissionValue() {
        return commissionValue;
    }

    public void setCommissionValue(double commissionValue) {
        this.commissionValue = commissionValue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commissions that = (Commissions) o;
        return orderId == that.orderId && Double.compare(that.commissionValue, commissionValue) == 0 && Double.compare(that.profit, profit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, commissionValue, profit);
    }

    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }
}
