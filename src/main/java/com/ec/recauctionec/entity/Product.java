package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "product", schema = "recauction_db")
public class Product {
    public static final int MANUAL = 1;
    public static final int AUTOMATIC = 2;
    public static final int DISABLE = 0;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    private String detail;
    @Basic
    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "default_price", nullable = false, precision = 0)
    private double defaultPrice;
    @Basic
    @Column(name = "min_price", nullable = false, precision = 0)
    private double minPrice;
    @Basic
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @Basic
    @Column(name = "isDeleted")
    private boolean isDeleted = false;
    @Basic
    @Column(name = "product_tag")
    private String productTag;

    @OneToMany(mappedBy = "productByProductId")
    private Collection<AuctSessJoin> auctSessJoinsByProductId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false,
            insertable = false, updatable = false)
    private Category categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", nullable = false,
            insertable = false, updatable = false)
    private Supplier supplierBySupplierId;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Collection<ProductImg> images;

    @OneToMany(mappedBy = "product")
    private Collection<Orders> orders;


}
