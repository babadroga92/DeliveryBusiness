package com.solvd.deliverybusiness.model;

public class Coupons {
    private int ID;
    private String code;
    private String name;
    private String restaurantID;

    public Coupons() {

    }

    public Coupons(int ID, String code, String name, String restaurantID) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.restaurantID = restaurantID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
