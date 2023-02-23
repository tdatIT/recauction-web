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
    
    @Column(name = "city", nullable = false, length = 255)
    private int city;
    
    @Column(name = "country", nullable = false, length = 255)
    private int country;
    
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
