package com.solvd.deliverybusiness.model;

public class Menu {
    private int ID;
    private String menu;
    private boolean isActive;
    private int restaurantID;

    public Menu() {
    }

    public Menu(int ID, String menu, boolean isActive, int restaurantID) {
        this.ID = ID;
        this.menu = menu;
        this.isActive = isActive;
        this.restaurantID = restaurantID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
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
}
