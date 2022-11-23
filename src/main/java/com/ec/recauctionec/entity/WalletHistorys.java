package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "wallet_historys", schema = "ec_db_nhom2", catalog = "")
public class WalletHistorys {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "No_history", nullable = false)
    private int noHistory;
    @Basic
    @Column(name = "wallet_id", nullable = false)
    private int walletId;
    @Basic
    @Column(name = "value", nullable = false, precision = 0)
    private double value;
    @Basic
    @Column(name = "type", nullable = false)
    private boolean type;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id", nullable = false,insertable = false,updatable = false)
    private Wallets walletsByWalletId;

    public int getNoHistory() {
        return noHistory;
    }

    public void setNoHistory(int noHistory) {
        this.noHistory = noHistory;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletHistorys that = (WalletHistorys) o;
        return noHistory == that.noHistory && walletId == that.walletId && Double.compare(that.value, value) == 0 && type == that.type && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noHistory, walletId, value, type, createDate);
    }

    public Wallets getWalletsByWalletId() {
        return walletsByWalletId;
    }

    public void setWalletsByWalletId(Wallets walletsByWalletId) {
        this.walletsByWalletId = walletsByWalletId;
    }
}
