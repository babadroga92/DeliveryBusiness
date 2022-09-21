package com.solvd.deliverybusiness.model;

import java.sql.Date;

public class OpeningHours {
    private int id;
    private Date fromTime;
    private Date toTime;
    private int weekDayID;
    private int restaurantID;

    public OpeningHours() {
    }

    public OpeningHours(int id, Date fromTime, Date toTime, int weekDayID, int restaurantID) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.weekDayID = weekDayID;
        this.restaurantID = restaurantID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public int getWeekDayID() {
        return weekDayID;
    }

    public void setWeekDayID(int weekDayID) {
        this.weekDayID = weekDayID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
}
