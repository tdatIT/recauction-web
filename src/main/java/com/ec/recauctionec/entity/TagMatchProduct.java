package com.ec.recauctionec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tag_match_product", schema = "ec_final_project", catalog = "")
@IdClass(TagMatchProductPK.class)
public class TagMatchProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tag_id", nullable = false)
    private long tagId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private int productId;
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "ptag_id", nullable = false,
            insertable = false, updatable = false)
    private ProductTag productTagByTagId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false,
            insertable = false, updatable = false)
    private Product productByProductId;

}
