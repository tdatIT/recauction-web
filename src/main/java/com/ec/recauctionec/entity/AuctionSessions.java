package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "auction_sessions", schema = "ec_db_nhom2", catalog = "")
public class AuctionSessions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auction_sess_id", nullable = false)
    private int auctionSessId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "reserve_price", nullable = false, precision = 0)
    private double reservePrice;
    @Basic
    @Column(name = "closing_price", nullable = true, precision = 0)
    private Double closingPrice;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "isComplete", nullable = false)
    private boolean isComplete;
    @OneToMany(mappedBy = "auctionSessionsByAuctionSessId")
    private Collection<AuctSessJoin> auctSessJoinsByAuctionSessId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false,updatable = false)
    private Users usersByUserId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false,insertable = false,updatable = false)
    private Products productsByProductId;

    public int getAuctionSessId() {
        return auctionSessId;
    }

    public void setAuctionSessId(int auctionSessId) {
        this.auctionSessId = auctionSessId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionSessions that = (AuctionSessions) o;
        return auctionSessId == that.auctionSessId && userId == that.userId && productId == that.productId && Double.compare(that.reservePrice, reservePrice) == 0 && isComplete == that.isComplete && Objects.equals(closingPrice, that.closingPrice) && Objects.equals(createDate, that.createDate) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionSessId, userId, productId, reservePrice, closingPrice, createDate, startDate, endDate, isComplete);
    }

    public Collection<AuctSessJoin> getAuctSessJoinsByAuctionSessId() {
        return auctSessJoinsByAuctionSessId;
    }

    public void setAuctSessJoinsByAuctionSessId(Collection<AuctSessJoin> auctSessJoinsByAuctionSessId) {
        this.auctSessJoinsByAuctionSessId = auctSessJoinsByAuctionSessId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
