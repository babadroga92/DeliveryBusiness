package com.solvd.deliverybusiness.model;

public class MenuGroup {
    private int id;
    private String name;
    private int menuID;

    public MenuGroup() {
    }

    public MenuGroup(int id, String name, int menuID) {
        this.id = id;
        this.name = name;
        this.menuID = menuID;
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

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }
}
