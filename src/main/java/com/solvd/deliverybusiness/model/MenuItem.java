package com.solvd.deliverybusiness.model;

public class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;
    private int menuGroupID;

    public MenuItem() {
    }

    public MenuItem(int id, String name, String description, double price, int menuGroupID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuGroupID = menuGroupID;
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
