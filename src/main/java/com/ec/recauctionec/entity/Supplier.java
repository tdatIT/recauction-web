package com.ec.recauctionec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
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
    @Column(name = "owner_id", nullable = false)
    private int ownerId;
    @Basic
    @Column(name = "rating", nullable = false)
    private int rating;
    @OneToMany(mappedBy = "supplierBySupplierId", fetch = FetchType.EAGER)
    private Collection<Product> productsBySupplierId;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id", nullable = false,
            insertable = false, updatable = false)
    private User userByOwnerId;
}
