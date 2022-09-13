package com.solvd.deliverybusiness.model;

public class City {
    private int ID;
    private String name;
    private String zipCode;
    public City(){

    }

    public City(int ID, String name, String zipCode) {
        this.ID = ID;
        this.name = name;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
