package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao implements IMenuDao{
    private Connection connection;
    private static Logger log = LogManager.getLogger(Menu.class.getName());

    public MenuDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Menu> getAll() {
        List<Menu> listaMenija = new ArrayList<>();
        String query = "Select * from deliverybusiness.Menu";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                    listaMenija.add(new Menu(rez.getInt("ID"), rez.getString("Name"),
                            rez.getBoolean("isActive"), rez.getInt("restaurant_id")));
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaMenija;
    }


    @Override
    public Menu getByID(int id) {
        try {
            String query = "Select * from businessdelivery.Menu where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Menu(rs.getInt("ID"), rs.getString("Name"), rs.getBoolean("isActive"), rs.getInt("restaurant_id"));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public void create(Menu menu) {
        try {
            String query = "Insert into deliverybusiness.Menu(Name, isActive, restaurant_id) values(?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, menu.getName());
            ps.setBoolean(2, menu.isActive());
            ps.setInt(3, menu.getRestaurantID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Menu menu) {
        try {
            String query = "Update deliverybusiness.Menu set Name=? where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, menu.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public String delete(int id) {
        try {
            String query = "Delete from deliverybusiness.Menu where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Menu deleted";
        }
        catch (SQLException ex) {
            log.error("Error" + ex.getMessage());
            return "Menu removed";
        }
    }

    @Override
    public List<Menu> restaurantMenu(Restaurant restaurant) {
        try {
            String query = "Select * from deliverybusiness.Menu where restaurant_id=? and isActive=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, restaurant.getID());
            ps.setBoolean(2, restaurant.isActive());
            ResultSet rs = ps.executeQuery();
            List<Menu> listaMenija = new ArrayList<>();
            if (rs.next()) {
                listaMenija.add(new Menu(rs.getInt("ID"), rs.getString("Name"), rs.getBoolean("isActive"), rs.getInt("restaurant_id")));
            }
            return listaMenija;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
}
