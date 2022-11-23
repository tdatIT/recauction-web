package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "name", nullable = false, length = 10)
    private String name;
    @Basic
    @Column(name = "desciption", nullable = true, length = 255)
    private String desciption;
    @OneToMany(mappedBy = "rolesByRoleId")
    private Collection<Users> usersByRoleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return roleId == roles.roleId && Objects.equals(name, roles.name) && Objects.equals(desciption, roles.desciption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name, desciption);
    }

    public Collection<Users> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Collection<Users> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
