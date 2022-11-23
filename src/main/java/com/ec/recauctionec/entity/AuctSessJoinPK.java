package com.ec.recauctionec.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuctSessJoinPK implements Serializable {
    @Column(name = "auction_sess_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionSessId;
    @Column(name = "supplier_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    public int getAuctionSessId() {
        return auctionSessId;
    }

    public void setAuctionSessId(int auctionSessId) {
        this.auctionSessId = auctionSessId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctSessJoinPK that = (AuctSessJoinPK) o;
        return auctionSessId == that.auctionSessId && supplierId == that.supplierId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionSessId, supplierId);
    }
}
