package com.solvd.deliverybusiness.model;

public class OrderItemExtra {
    private int id;
    private String quantity;
    private int orderItemID;
    private int menuItemID;
    private int menuItemExtraID;

    public OrderItemExtra() {
    }

    public OrderItemExtra(int id, String quantity, int orderItemID, int menuItemID, int menuItemExtraID) {
        this.id = id;
        this.quantity = quantity;
        this.orderItemID = orderItemID;
        this.menuItemID = menuItemID;
        this.menuItemExtraID = menuItemExtraID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public int getMenuItemExtraID() {
        return menuItemExtraID;
    }

    public void setMenuItemExtraID(int menuItemExtraID) {
        this.menuItemExtraID = menuItemExtraID;
    }
}
