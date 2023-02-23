package com.ec.recauctionec.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "user_address")
public class UserAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id", nullable = false)
    private int addressId;

    @Column(name = "province", nullable = false)
    private int province;

    @Column(name = "district", nullable = false)
    private int district;

    @Column(name = "address_detail", nullable = false)
    private String addressDetail;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "address")
    private Collection<Orders> orders;

}
