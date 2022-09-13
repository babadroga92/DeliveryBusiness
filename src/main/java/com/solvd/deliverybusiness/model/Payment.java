package com.solvd.deliverybusiness.model;

public class Payment {
    private int ID;
    private double amount;
    private int customerID;

    public Payment() {
    }

    public Payment(int ID, double amount, int customerID) {
        this.ID = ID;
        this.amount = amount;
        this.customerID = customerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
