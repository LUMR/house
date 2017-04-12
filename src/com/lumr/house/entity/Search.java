package com.lumr.house.entity;

/**
 * 搜索专用实体
 * Created by fsweb on 17-4-12.
 */
public class Search {
    private String title;
    private int priceLv;
    private int MaxPrice;
    private int MinPrice;
    private int floorage;
    private int MinAge;
    private int MaxAge;
    private int streetId;
    private int typeId;
    private static int[] PRICE = new int[]{0, 100, 200, 1000000, 100000000};
    private static int[] AGE = new int[]{0, 40, 500, 10000000};

    public Search(String title, int price, int floorage, int streetId, int typeId) {
        this.title = title;
        this.priceLv = price;
        this.floorage = floorage;
        this.streetId = streetId;
        this.typeId = typeId;
        setPrice(price);
        setAge(floorage);
    }

    public int getMaxPrice() {
        return MaxPrice;
    }

    public int getMinPrice() {
        return MinPrice;
    }

    public int getMinAge() {
        return MinAge;
    }

    public int getMaxAge() {
        return MaxAge;
    }

    private void setAge(int age) {
        if (age > 0) {
            MinAge = AGE[age - 1];
            MaxAge = AGE[age];
        } else {
            MinAge = AGE[0];
            MaxAge = AGE[3];
        }

    }

    private void setPrice(int priceLv) {
        if (priceLv > 0) {
            MinPrice = PRICE[priceLv - 1];
            MaxPrice = PRICE[priceLv];
        } else {
            MinPrice = PRICE[0];
            MaxPrice = PRICE[4];
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceLv() {
        return priceLv;
    }

    public void setPriceLv(int priceLv) {
        this.priceLv = priceLv;
        setPrice(priceLv);
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
