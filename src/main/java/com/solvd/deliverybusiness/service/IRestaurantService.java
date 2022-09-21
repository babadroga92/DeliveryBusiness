package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> getAllRestaurantsFromCity(String city);
    public Restaurant getRestaurantsByID(int id);
    public void createRestaurant(Restaurant restaurant);
    public void updateRestaurant(int id, Restaurant restaurant);
    public String deleteRestaurant(int id) throws DatabaseException;
}
