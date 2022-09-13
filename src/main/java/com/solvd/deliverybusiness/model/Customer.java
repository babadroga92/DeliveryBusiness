package com.solvd.deliverybusiness.model;

public class Customer {
    private int ID;
    private String fullName;
    private String address;
    private int city;

    public Customer(){

    }

    public Customer(int ID, String fullName, String address, int city) {
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }

    public void setCity(int city) {
        this.city = city;
    }
}
