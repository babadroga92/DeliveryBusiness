package com.solvd.deliverybusiness.model;

public class MenuItemExtra {
    private int id;
    private String name;
    private String description;
    private boolean price;
    private int menuItemID;

    public MenuItemExtra() {
    }

    public MenuItemExtra(int id, String name, String description, boolean price, int menuItemID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuItemID = menuItemID;
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

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }
}
