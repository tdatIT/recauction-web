package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="category", schema = "reauction_db")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;
    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    private String detail;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<AuctionSession> auctionSessionsByCategoryId;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Product> productsByCategoryId;


}
