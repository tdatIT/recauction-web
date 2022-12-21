package com.ec.recauctionec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "wallet_history", schema = "recauction_db", catalog = "")
public class WalletHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no_history", nullable = false)
    private int noHistory;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "type", nullable = false)
    private boolean type;
    @Basic
    @Column(name = "value", nullable = false, precision = 0)
    private double value;

    @Basic
    @Column(name = "payment_id")
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
