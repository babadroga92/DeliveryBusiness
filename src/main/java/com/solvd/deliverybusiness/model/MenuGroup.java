package com.solvd.deliverybusiness.model;

public class MenuGroup {
    private int ID;
    private String name;
    private int menuID;

    public MenuGroup() {
    }

    public MenuGroup(int ID, String name, int menuID) {
        this.ID = ID;
        this.name = name;
        this.menuID = menuID;
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

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }
}
