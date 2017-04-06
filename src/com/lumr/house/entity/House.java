package com.lumr.house.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by fsweb on 17-4-6.
 */
@Entity
public class House {
    private int id;
    private int userId;
    private int typeId;
    private int streetId;
    private String title;
    private String description;
    private Integer price;
    private Date pubdate;
    private String floorage;
    private String contact;

    public House(int userId, int typeId, int streetId, String title, String description, Integer price, Date pubdate, String floorage, String contact) {
        this.userId = userId;
        this.typeId = typeId;
        this.streetId = streetId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.pubdate = pubdate;
        this.floorage = floorage;
        this.contact = contact;
    }

    public House() {
    }

    @Column(name = "STREET_ID")
    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Column(name = "TYPE_ID")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "PUBDATE")
    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Basic
    @Column(name = "FLOORAGE")
    public String getFloorage() {
        return floorage;
    }

    public void setFloorage(String floorage) {
        this.floorage = floorage;
    }

    @Basic
    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        if (id != house.id) return false;
        if (title != null ? !title.equals(house.title) : house.title != null) return false;
        if (description != null ? !description.equals(house.description) : house.description != null) return false;
        if (price != null ? !price.equals(house.price) : house.price != null) return false;
        if (pubdate != null ? !pubdate.equals(house.pubdate) : house.pubdate != null) return false;
        if (floorage != null ? !floorage.equals(house.floorage) : house.floorage != null) return false;
        if (contact != null ? !contact.equals(house.contact) : house.contact != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pubdate != null ? pubdate.hashCode() : 0);
        result = 31 * result + (floorage != null ? floorage.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }
}
