package com.solvd.deliverybusiness.model;

public class Coupons {
    private int id;
    private String code;
    private String name;
    private String restaurantID;

    public Coupons() {

    }

    public Coupons(int id, String code, String name, String restaurantID) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.restaurantID = restaurantID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }
}
