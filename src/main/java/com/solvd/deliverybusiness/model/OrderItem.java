package com.solvd.deliverybusiness.model;

public class OrderItem {
    private int id;
    private int orderID;
    private int menuItemID;
    private double quantity;

    public OrderItem() {
    }

    public OrderItem(int id, int orderID, int menuItemID, double quantity) {
        this.id = id;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
