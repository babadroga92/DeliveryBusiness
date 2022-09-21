package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IRestaurantDao {
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> getAllRestaurantsFromCity(String city);
    public Restaurant getRestaurantsById(int id);
    public void createRestaurant(Restaurant restaurant);
    public void updateRestaurant(int id, Restaurant restaurant);
    public String deleteRestaurant(int id);


}
