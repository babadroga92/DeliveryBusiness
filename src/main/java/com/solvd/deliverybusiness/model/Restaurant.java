package com.solvd.deliverybusiness.model;

public class Restaurant {
    private int ID;
    private String name;
    private boolean isActive;
    private String description;
    private int cityID;

    public Restaurant() {
    }

    public Restaurant(int ID, String name, boolean isActive, String description, int cityID) {
        this.ID = ID;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.cityID = cityID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                ", cityID=" + cityID +
                '}';
    }
}
