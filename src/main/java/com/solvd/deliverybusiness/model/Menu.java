package com.solvd.deliverybusiness.model;

public class Menu {
    private int ID;
    private String name;
    private boolean isActive;
    private int restaurantID;

    public Menu() {
    }

    public Menu(int ID, String name, boolean isActive, int restaurantID) {
        this.ID = ID;
        this.name = name;
        this.isActive = isActive;
        this.restaurantID = restaurantID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", restaurantID=" + restaurantID +
                '}';
    }
}
