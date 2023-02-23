package com.ec.recauctionec.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "wallet")
public class Wallet {
    public static int USD_TO_VND = 23800;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "wallet_id", nullable = false)
    private int walletId;
    
    @Column(name = "account_balance", nullable = false, precision = 0)
    private double accountBalance = 0D;
    
    @Column(name = "isActive", nullable = false)
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet")
    private Collection<WalletHistory> walletHistories;


}
