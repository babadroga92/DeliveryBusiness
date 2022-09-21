package com.solvd.deliverybusiness.model;

public class Payment {
    private int id;
    private double amount;
    private int customerID;

    public Payment() {
    }

    public Payment(int id, double amount, int customerID) {
        this.id = id;
        this.amount = amount;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
