package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Suppliers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @Basic
    @Column(name = "owner_id", nullable = false)
    private int ownerId;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "rating", nullable = false)
    private int rating;
    @Basic
    @Column(name = "level_supp", nullable = false)
    private int levelSupp;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(mappedBy = "suppliersBySupplierId")
    private Collection<AuctSessJoin> auctSessJoinsBySupplierId;
    @OneToMany(mappedBy = "suppliersBySupplierId")
    private Collection<Products> productsBySupplierId;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id", nullable = false,insertable = false,updatable = false)
    private Users usersByOwnerId;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLevelSupp() {
        return levelSupp;
    }

    public void setLevelSupp(int levelSupp) {
        this.levelSupp = levelSupp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        Suppliers suppliers = (Suppliers) o;
        return supplierId == suppliers.supplierId && ownerId == suppliers.ownerId && rating == suppliers.rating && levelSupp == suppliers.levelSupp && isActive == suppliers.isActive && Objects.equals(name, suppliers.name) && Objects.equals(createDate, suppliers.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, ownerId, name, rating, levelSupp, createDate, isActive);
    }

    public Collection<AuctSessJoin> getAuctSessJoinsBySupplierId() {
        return auctSessJoinsBySupplierId;
    }

    public void setAuctSessJoinsBySupplierId(Collection<AuctSessJoin> auctSessJoinsBySupplierId) {
        this.auctSessJoinsBySupplierId = auctSessJoinsBySupplierId;
    }

    public Collection<Products> getProductsBySupplierId() {
        return productsBySupplierId;
    }

    public void setProductsBySupplierId(Collection<Products> productsBySupplierId) {
        this.productsBySupplierId = productsBySupplierId;
    }

    public Users getUsersByOwnerId() {
        return usersByOwnerId;
    }

    public void setUsersByOwnerId(Users usersByOwnerId) {
        this.usersByOwnerId = usersByOwnerId;
    }
}
