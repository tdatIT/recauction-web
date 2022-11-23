package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wallet_links", schema = "ec_db_nhom2", catalog = "")
public class WalletLinks {
    @Basic
    @Column(name = "wallet_id", nullable = false)
    private int walletId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bank_number", nullable = false, length = 20)
    private String bankNumber;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id", nullable = false,insertable = false,updatable = false)
    private Wallets walletsByWalletId;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
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
        WalletLinks that = (WalletLinks) o;
        return walletId == that.walletId && isActive == that.isActive && Objects.equals(bankNumber, that.bankNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, bankNumber, isActive);
    }

    public Wallets getWalletsByWalletId() {
        return walletsByWalletId;
    }

    public void setWalletsByWalletId(Wallets walletsByWalletId) {
        this.walletsByWalletId = walletsByWalletId;
    }
}
