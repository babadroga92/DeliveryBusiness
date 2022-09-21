package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao implements IRestaurantDao {

    private Connection connection;

    private String getAllFromRestaurant = "Select * from Restaurant";

    private String getAllRestaurantsFromCity = "Select * from deliverybusiness.Restaurant r join deliverybusiness.City c " +
            "on r.city_ID=c.ID where c.name=?";

    private String insertIntoRestaurant = "Insert into Restaurant(Name, is_active, Description, City_ID) values(?,?,?,?) ";

    private String updateRestaurant = "Update deliverybusiness.Restaurant set Name=? where ID=?";

    private String deleteFromRestaurant = "Delete from Restaurant where ID=?";

    public RestaurantDao(Connection connection) {
        this.connection = connection;
    }

    private static Logger log = LogManager.getLogger(RestaurantDao.class.getName());

    public String getGetAllFromRestaurant() {
        return getAllFromRestaurant;
    }
    public String getGetAllRestaurantsFromCity() {
        return getAllRestaurantsFromCity;
    }
    public String getInsertIntoRestaurant() {
        return insertIntoRestaurant;
    }
    public String getUpdateRestaurant() {
        return updateRestaurant;
    }
    public String getDeleteFromRestaurant() {
        return deleteFromRestaurant;
    }
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> listaRestorana = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromRestaurant());
            ResultSet rez = ps.executeQuery();
            while (rez.next()) {
                listaRestorana.add(new Restaurant(rez.getInt("ID"), rez.getString("Name"),
                        rez.getBoolean("is_active"),
                        rez.getString("description"), rez.getInt("City_ID")));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaRestorana;
    }
    @Override
    public List<Restaurant> getAllRestaurantsFromCity(String city) {
        List<Restaurant> listaRestorana = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllRestaurantsFromCity());
            ps.setString(1, city);
            ResultSet rez = ps.executeQuery();
            while (rez.next()) {
                listaRestorana.add(new Restaurant(rez.getInt("ID"), rez.getString("Name"),
                        rez.getBoolean("is_active"),
                        rez.getString("description"), rez.getInt("City_ID")));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return listaRestorana;
    }
    @Override
    public Restaurant getRestaurantsById(int id) {
        return null;
    }
    @Override
    public void createRestaurant(Restaurant restaurant) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getInsertIntoRestaurant());
            ps.setString(1, restaurant.getName());
            ps.setBoolean(2, restaurant.isActive());
            ps.setString(3, restaurant.getDescription());
            ps.setInt(4, restaurant.getCityID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void updateRestaurant(int id, Restaurant restaurant) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getUpdateRestaurant());
            ps.setString(1, restaurant.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }
    @Override
    public String deleteRestaurant(int id) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getDeleteFromRestaurant());
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Restaurant deleted";
        } catch (SQLException ex) {
            log.error("Error" + ex.getMessage());
            return "Restaurant removed";
        }
    }
    private PreparedStatement createPreparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
}

