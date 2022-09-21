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

    private String updateRestaurant = "Update deliverybusiness.Restaurant set Name=? and is_active=? and Description=? and City_ID=? where ID=?";

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
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromRestaurant());
            return listaRest(ps);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
    @Override
    public List<Restaurant> getAllRestaurantsFromCity(String city) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllRestaurantsFromCity());
            ps.setString(1, city);
            return listaRest(ps);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }
    @Override
    public Restaurant getRestaurantsById(int id) {
        return null;
    }
    @Override
    public void createRestaurant(Restaurant restaurant) {
        try {
            psSet(getInsertIntoRestaurant(), restaurant, 0);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void updateRestaurant(int id, Restaurant restaurant) {
        try {
            psSet(getUpdateRestaurant(), restaurant,id);
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
    private void psSet(String query, Restaurant restaurant, int id) throws SQLException{
        PreparedStatement ps = this.createPreparedStatement(query);
        ps.setString(1, restaurant.getName());
        ps.setBoolean(2, restaurant.isActive());
        ps.setString(3, restaurant.getDescription());
        ps.setInt(4, restaurant.getCityID());
        if(id!=0){
            ps.setInt(5,id);
        }

        ps.executeUpdate();
    }
    private PreparedStatement createPreparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }

    private List<Restaurant> listaRest(PreparedStatement ps) throws SQLException {
        ResultSet rez = ps.executeQuery();
        List<Restaurant> listaRestorana = new ArrayList<>();
        while (rez.next()) {
            listaRestorana.add(new Restaurant(rez.getInt("ID"), rez.getString("Name"),
                    rez.getBoolean("is_active"),
                    rez.getString("description"), rez.getInt("City_ID")));
        }
        return listaRestorana;
    }
}

