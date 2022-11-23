package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Wallets {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "wallet_id", nullable = false)
    private int walletId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "account_balance", nullable = false, precision = 0)
    private double accountBalance;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(mappedBy = "walletsByWalletId")
    private Collection<WalletHistorys> walletHistorysByWalletId;
    @OneToMany(mappedBy = "walletsByWalletId")
    private Collection<WalletLinks> walletLinksByWalletId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false,updatable = false)
    private Users usersByUserId;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallets wallets = (Wallets) o;
        return walletId == wallets.walletId && userId == wallets.userId && Double.compare(wallets.accountBalance, accountBalance) == 0 && isActive == wallets.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, userId, accountBalance, isActive);
    }

    public Collection<WalletHistorys> getWalletHistorysByWalletId() {
        return walletHistorysByWalletId;
    }

    public void setWalletHistorysByWalletId(Collection<WalletHistorys> walletHistorysByWalletId) {
        this.walletHistorysByWalletId = walletHistorysByWalletId;
    }

    public Collection<WalletLinks> getWalletLinksByWalletId() {
        return walletLinksByWalletId;
    }

    public void setWalletLinksByWalletId(Collection<WalletLinks> walletLinksByWalletId) {
        this.walletLinksByWalletId = walletLinksByWalletId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
