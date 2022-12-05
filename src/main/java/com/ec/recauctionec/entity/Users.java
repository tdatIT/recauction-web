package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive = false;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "level_user", nullable = false)
    private int levelUser;
    @Basic
    @Column(name = "encrypt_password", nullable = false, length = 255)
    private String encryptPassword;
    @Basic
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<AuctionSessions> auctionSessionsByUserId;
    @OneToMany(mappedBy = "usersByOwnerId")
    private Collection<Suppliers> suppliersByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<UserAddress> userAddressesByUserId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    private Roles rolesByRoleId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Wallets> walletsByUserId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLevelUser() {
        return levelUser;
    }

    public void setLevelUser(int levelUser) {
        this.levelUser = levelUser;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && roleId == users.roleId && isActive == users.isActive && levelUser == users.levelUser && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(phoneNumber, users.phoneNumber) && Objects.equals(email, users.email) && Objects.equals(avatar, users.avatar) && Objects.equals(encryptPassword, users.encryptPassword) && Objects.equals(username, users.username) && Objects.equals(createDate, users.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, phoneNumber, email, roleId, isActive, avatar, levelUser, encryptPassword, username, createDate);
    }

    public Collection<AuctionSessions> getAuctionSessionsByUserId() {
        return auctionSessionsByUserId;
    }

    public void setAuctionSessionsByUserId(Collection<AuctionSessions> auctionSessionsByUserId) {
        this.auctionSessionsByUserId = auctionSessionsByUserId;
    }

    public Collection<Suppliers> getSuppliersByUserId() {
        return suppliersByUserId;
    }

    public void setSuppliersByUserId(Collection<Suppliers> suppliersByUserId) {
        this.suppliersByUserId = suppliersByUserId;
    }

    public Collection<UserAddress> getUserAddressesByUserId() {
        return userAddressesByUserId;
    }

    public void setUserAddressesByUserId(Collection<UserAddress> userAddressesByUserId) {
        this.userAddressesByUserId = userAddressesByUserId;
    }

    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }

    public Collection<Wallets> getWalletsByUserId() {
        return walletsByUserId;
    }

    public void setWalletsByUserId(Collection<Wallets> walletsByUserId) {
        this.walletsByUserId = walletsByUserId;
    }
}
