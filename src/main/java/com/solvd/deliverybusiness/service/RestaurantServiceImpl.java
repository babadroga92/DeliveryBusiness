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
    public List<Restaurant> getAll() {
        return this.restaurantDao.getAll();
    }

    @Override
    public List<Restaurant> getAllFromCity(String city) {
        return this.restaurantDao.getAllFromCity(city);
    }

    @Override
    public Restaurant getByID(int id) {
        return null;
    }

    @Override
    public void create(Restaurant restaurant) {
        this.restaurantDao.create(restaurant);
    }

    @Override
    public void update(int id, Restaurant restaurant) {

    }
    @Override
    public String delete(int id) throws DatabaseException {
            if(id<1) {
                throw new DatabaseException("Error");
            }
            return this.restaurantDao.delete(id);
        }
    }

