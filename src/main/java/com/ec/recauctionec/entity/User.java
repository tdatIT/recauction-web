package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "user", schema = "reauction_db")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Basic
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "level_user", nullable = false)
    private int levelUser;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<AuctionSession> auctionSessionsByUserId;
    @OneToMany(mappedBy = "userByOwnerId")
    private Collection<Supplier> suppliersByUserId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false,
            insertable = false, updatable = false)
    private Role roleByRoleId;
    @OneToMany(mappedBy = "userByUserId",fetch = FetchType.LAZY)
    private Collection<UserAddress> userAddressesByUserId;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Wallet> walletsByUserId;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Orders> orders;

}
