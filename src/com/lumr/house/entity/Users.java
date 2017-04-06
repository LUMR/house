package com.lumr.house.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by fsweb on 17-4-6.
 */
@Entity
public class Users {
    private int id;
    private String name;
    private String password;
    private String telephone;
    private String username;
    private String isadmin;

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Users(String name, String password, String telephone, String username) {
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.username = username;
        isadmin = "no";
    }

    public Users() {
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "ISADMIN")
    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (telephone != null ? !telephone.equals(users.telephone) : users.telephone != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (isadmin != null ? !isadmin.equals(users.isadmin) : users.isadmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (isadmin != null ? isadmin.hashCode() : 0);
        return result;
    }
}
