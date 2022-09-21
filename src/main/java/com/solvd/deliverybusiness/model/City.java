package com.solvd.deliverybusiness.model;

public class City {
    private int id;
    private String name;
    private String zipCode;

    public City() {

    }

    public City(int id, String name, String zipCode) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
