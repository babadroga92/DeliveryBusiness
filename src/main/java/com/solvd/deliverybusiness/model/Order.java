package com.solvd.deliverybusiness.model;

import java.sql.Date;

public class Order {
    private int ID;
    private Date orderDate;
    private Date preparedDate;
    private Date takenOverDate;
    private boolean isPaid;
    private double price;
    private String note;

    private Restaurant restaurant;

    private Customer customer;
    private int couponsID;
    private int orderStatusID;

    public Order() {
    }
    public Order( Date orderDate, Date preparedDate, Date takenOverDate, boolean isPaid, double price, String note, Restaurant restaurant, Customer customer, int couponsID, int orderStatusID) {
        this.orderDate = orderDate;
        this.preparedDate = preparedDate;
        this.takenOverDate = takenOverDate;
        this.isPaid = isPaid;
        this.price = price;
        this.note = note;
        this.restaurant = restaurant;
        this.customer = customer;
        this.couponsID = couponsID;
        this.orderStatusID = orderStatusID;
    }


    public Order(int ID, Date orderDate, Date preparedDate, Date takenOverDate, boolean isPaid, double price, String note, Restaurant restaurant, Customer customer, int couponsID, int orderStatusID) {
        this.ID = ID;
        this.orderDate = orderDate;
        this.preparedDate = preparedDate;
        this.takenOverDate = takenOverDate;
        this.isPaid = isPaid;
        this.price = price;
        this.note = note;
        this.restaurant = restaurant;
        this.customer = customer;
        this.couponsID = couponsID;
        this.orderStatusID = orderStatusID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Date getTakenOverDate() {
        return takenOverDate;
    }

    public void setTakenOverDate(Date takenOverDate) {
        this.takenOverDate = takenOverDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCouponsID() {
        return couponsID;
    }

    public void setCouponsID(int couponsID) {
        this.couponsID = couponsID;
    }

    public int getOrderStatusID() {
        return orderStatusID;
    }

    public void setOrderStatusID(int orderStatusID) {
        this.orderStatusID = orderStatusID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", isPaid=" + isPaid +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", restaurant=" + restaurant +
                ", customer=" + customer +
                ", couponsID=" + couponsID +
                ", orderStatusID=" + orderStatusID +
                '}';
    }
}
