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

public class RestaurantDao implements IRestaurantDao{

    private Connection connection;

    public RestaurantDao(Connection connection) {
        this.connection = connection;
    }

    private static Logger log = LogManager.getLogger(RestaurantDao.class.getName());
    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> listaRestorana = new ArrayList<>();
        String query = "Select * from Restaurant";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                   // public Restaurant(int ID, String name, boolean isActive, String description, int cityID) {
                    listaRestorana.add(new Restaurant(rez.getInt("ID"), rez.getString("Name"),
                            rez.getBoolean("is_active"),
                            rez.getString("description"),rez.getInt("City_ID")));
                }

            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaRestorana;

    }

    @Override
    public List<Restaurant> getAllFromCity(String city) {
        List<Restaurant> listaRestorana = new ArrayList<>();
        String query = "Select * from deliverybusiness.Restaurant r join deliverybusiness.City c " +
                "on r.city_ID=c.ID where c.name=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city);
            try {
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                    listaRestorana.add(new Restaurant(rez.getInt("ID"), rez.getString("Name"),
                            rez.getBoolean("is_active"),
                            rez.getString("description"),rez.getInt("City_ID")));
                }

            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaRestorana;
    }

    @Override
    public Restaurant getByID(int id) {
        return null;
    }

    @Override
    public void create(Restaurant restaurant) {
        try {
            String query = "Insert into Restaurant(Name, is_active, Description, City_ID) values(?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, restaurant.getName());
            ps.setBoolean(2, restaurant.isActive());
            ps.setString(3, restaurant.getDescription());
            ps.setInt(4, restaurant.getCityID());
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }
    @Override
    public void update(int id, Restaurant restaurant) {
        try {
            String query = "Update deliverybusiness.Restaurant set Name=? where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,restaurant.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }

    }
    @Override
    public String delete(int id) {
            try {
                String query = "Delete from Restaurant where ID=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                return "Restaurant deleted";
            } catch (SQLException ex) {
                log.error("Error" + ex.getMessage());
                return "Restaurant removed";
            }
    }
}

