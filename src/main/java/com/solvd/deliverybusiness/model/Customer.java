package com.solvd.deliverybusiness.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
public class Customer {
    private int id;
    private String fullName;
    private String address;
    private int city;

    public Customer() {

    }

    public Customer(int id, String fullName, String address, int city) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
    }

    public int getId() {
        return id;
    }
    @XmlElement(name="ID")
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    @XmlElement(name="FullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }
    @XmlElement (name="Address")
    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city;
    }
    @XmlElement (name="City")
    public void setCity(int city) {

        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }
}
