package com.solvd.deliverybusiness.model;

public class MenuItemExtra {
    private int ID;
    private String name;
    private String description;
    private boolean price;
    private int menuItemID;

    public MenuItemExtra() {
    }

    public MenuItemExtra(int ID, String name, String description, boolean price, int menuItemID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuItemID = menuItemID;
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
