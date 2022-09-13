package com.solvd.deliverybusiness.model;

public class WeekDay {
    private int ID;
    private String day;

    public WeekDay() {
    }

    public WeekDay(int ID, String day) {
        this.ID = ID;
        this.day = day;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
