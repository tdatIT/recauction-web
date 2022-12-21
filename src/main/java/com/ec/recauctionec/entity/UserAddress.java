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
@Table(name = "user_address", schema = "recauction_db", catalog = "")
public class UserAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Basic
    @Column(name = "city", nullable = false, length = 255)
    private String city;
    @Basic
    @Column(name = "country", nullable = false, length = 255)
    private String country;
    @Basic
    @Column(name = "district", nullable = false)
    private int district;
    @Basic
    @Column(name = "address_detail", nullable = false)
    private String addressDetail;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userByUserId;

    @OneToMany(mappedBy = "address")
    private Collection<Orders> orders;

}
