package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.dao.RestaurantDao;
import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public class RestaurantServiceImpl implements IRestaurantService{
    private RestaurantDao restaurantDao;

    public RestaurantServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantDao.getAllRestaurants();
    }

    @Override
    public List<Restaurant> getAllRestaurantsFromCity(String city) {
        return this.restaurantDao.getAllRestaurantsFromCity(city);
    }

    @Override
    public Restaurant getRestaurantsByID(int id) {
        return null;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        this.restaurantDao.createRestaurant(restaurant);
    }

    @Override
    public void updateRestaurant(int id, Restaurant restaurant) {

    }
    @Override
    public String deleteRestaurant(int id) throws DatabaseException {
            if(id<1) {
                throw new DatabaseException("Error");
            }
            return this.restaurantDao.deleteRestaurant(id);
        }
    }

