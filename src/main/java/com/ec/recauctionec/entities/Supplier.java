package com.ec.recauctionec.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "supplier")
public class Supplier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    @Column(name = "createDate", nullable = false)
    private Date createDate;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "level_supp", nullable = false)
    private int levelSupp;

    @Column(name = "location", nullable = false)
    private int location;

    @Column(name = "rating", nullable = false)
    private int rating;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Collection<Product> products;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User user;
}
