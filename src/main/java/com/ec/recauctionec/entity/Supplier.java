package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "supplier", schema = "reauction_db")
public class Supplier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Basic
    @Column(name = "level_supp", nullable = false)
    private int levelSupp;
    @Basic
    @Column(name = "location", nullable = false)
    private int location;
    @Basic
    @Column(name = "rating", nullable = false)
    private int rating;
    @OneToMany(mappedBy = "supplierBySupplierId", fetch = FetchType.EAGER)
    private Collection<Product> productsBySupplierId;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User userByOwnerId;
}
