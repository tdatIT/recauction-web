package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "wallet", schema = "reauction_db")
public class Wallet {
    public static final int USD_TO_VND = 23800;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "wallet_id", nullable = false)
    private int walletId;
    @Basic
    @Column(name = "account_balance", nullable = false, precision = 0)
    private double accountBalance = 0D;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet")
    private Collection<WalletHistory> walletHistoriesByWalletId;


}
