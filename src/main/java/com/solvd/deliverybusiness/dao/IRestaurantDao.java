package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IRestaurantDao {
    public List<Restaurant> getAll();
    public List<Restaurant> getAllFromCity(String city);
    public Restaurant getByID(int id);
    public void create(Restaurant restaurant);
    public void update(int id, Restaurant restaurant);
    public String delete(int id);


}
