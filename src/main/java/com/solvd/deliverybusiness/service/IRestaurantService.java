package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    public List<Restaurant> getAll();
    public List<Restaurant> getAllFromCity(String city);
    public Restaurant getByID(int id);
    public void create(Restaurant restaurant);
    public void update(int id, Restaurant restaurant);
    public String delete(int id) throws DatabaseException;
}
