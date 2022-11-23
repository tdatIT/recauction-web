package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Deliveries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "delivery_id", nullable = false)
    private int deliveryId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "discount", nullable = false)
    private int discount;
    @OneToMany(mappedBy = "deliveriesByDeliveryId")
    private Collection<Orders> ordersByDeliveryId;

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliveries that = (Deliveries) o;
        return deliveryId == that.deliveryId && discount == that.discount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, name, discount);
    }

    public Collection<Orders> getOrdersByDeliveryId() {
        return ordersByDeliveryId;
    }

    public void setOrdersByDeliveryId(Collection<Orders> ordersByDeliveryId) {
        this.ordersByDeliveryId = ordersByDeliveryId;
    }
}
