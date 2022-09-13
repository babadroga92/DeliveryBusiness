package com.solvd.deliverybusiness.model;

public class MenuItem {
    private int ID;
    private String name;
    private String description;
    private double price;
    private int menuGroupID;

    public MenuItem() {
    }

    public MenuItem(int ID, String name, String description, double price, int menuGroupID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuGroupID = menuGroupID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMenuGroupID() {
        return menuGroupID;
    }

    public void setMenuGroupID(int menuGroupID) {
        this.menuGroupID = menuGroupID;
    }
}
