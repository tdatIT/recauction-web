package com.ec.recauctionec.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
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
    
    @Column(name = "detail", nullable = true, length = 255)
    private String detail;
    
    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;
    
    @Column(name = "status", nullable = false)
    private int status;
    
    @Column(name = "default_price", nullable = false, precision = 0)
    private double defaultPrice;
    
    @Column(name = "min_price", nullable = false, precision = 0)
    private double minPrice;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;
    
    @Column(name = "product_tag")
    private String productTag;

    @OneToMany(mappedBy = "product")
    private Collection<AuctSessJoin> auctSessJoins;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Collection<ProductImg> images;

    @OneToMany(mappedBy = "product")
    private Collection<Orders> orders;


}
