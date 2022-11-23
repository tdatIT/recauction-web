package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "auct_sess_join", schema = "ec_db_nhom2", catalog = "")
@IdClass(AuctSessJoinPK.class)
public class AuctSessJoin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auction_sess_id", nullable = false)
    private int auctionSessId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @ManyToOne
    @JoinColumn(name = "auction_sess_id", referencedColumnName = "auction_sess_id", nullable = false,insertable = false,updatable = false)
    private AuctionSessions auctionSessionsByAuctionSessId;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", nullable = false,insertable = false,updatable = false)
    private Suppliers suppliersBySupplierId;
    @ManyToOne
    @JoinColumn(name = "auction_sess_id", referencedColumnName = "auction_sess_id", nullable = false,insertable = false,updatable = false)
    private Orders ordersByAuctionSessId;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctSessJoin that = (AuctSessJoin) o;
        return auctionSessId == that.auctionSessId && supplierId == that.supplierId && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionSessId, supplierId, price);
    }

    public AuctionSessions getAuctionSessionsByAuctionSessId() {
        return auctionSessionsByAuctionSessId;
    }

    public void setAuctionSessionsByAuctionSessId(AuctionSessions auctionSessionsByAuctionSessId) {
        this.auctionSessionsByAuctionSessId = auctionSessionsByAuctionSessId;
    }

    public Suppliers getSuppliersBySupplierId() {
        return suppliersBySupplierId;
    }

    public void setSuppliersBySupplierId(Suppliers suppliersBySupplierId) {
        this.suppliersBySupplierId = suppliersBySupplierId;
    }

    public Orders getOrdersByAuctionSessId() {
        return ordersByAuctionSessId;
    }

    public void setOrdersByAuctionSessId(Orders ordersByAuctionSessId) {
        this.ordersByAuctionSessId = ordersByAuctionSessId;
    }
}
