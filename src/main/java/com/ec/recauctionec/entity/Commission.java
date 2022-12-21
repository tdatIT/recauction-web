package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="commission", schema = "reauction_db")
public class Commission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "amount_from_buyer", nullable = false, precision = 0)
    private double amountFromBuyer;
    @Basic
    @Column(name = "amount_from_supplier", nullable = false, precision = 0)
    private double amountFromSupplier;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;


}
