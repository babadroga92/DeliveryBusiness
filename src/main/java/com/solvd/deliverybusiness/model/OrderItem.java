package com.solvd.deliverybusiness.model;

public class OrderItem {
    private int ID;
    private int orderID;
    private int menuItemID;
    private double quantity;

    public OrderItem() {
    }

    public OrderItem(int ID, int orderID, int menuItemID, double quantity) {
        this.ID = ID;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
