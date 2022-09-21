package com.solvd.deliverybusiness.model;

public class Menu {
    private int id;
    private String name;
    private boolean isActive;
    private int restaurantID;

    public Menu() {
    }

    public Menu(int id, String name, boolean isActive, int restaurantID) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.restaurantID = restaurantID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", restaurantID=" + restaurantID +
                '}';
    }
}
