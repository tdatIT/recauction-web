package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "product_img", schema = "recauction_db", catalog = "")
public class ProductImg {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "img_id", nullable = false)
    private int imgId;
    @Basic
    @Column(name = "img_name", nullable = false)
    private String imgName;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
