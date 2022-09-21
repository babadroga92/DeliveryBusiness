package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao implements IMenuDao {
    private Connection connection;

    private String getAllFromMenu = "Select * from deliverybusiness.Menu";
    private String getAllFromMenuWithId = "Select * from businessdelivery.Menu where ID=?";
    private String insertIntoMenu = "Insert into deliverybusiness.Menu(Name, isActive, restaurant_id) values(?,?,?) ";
    private String updateMenu = "Update deliverybusiness.Menu set Name=? and isActive=? where ID=?";
    private String deleteFromMenu = "Delete from deliverybusiness.Menu where ID=?";
    private String getMenuFromActiveRestaurants = "Select * from deliverybusiness.Menu where restaurant_id=? and isActive=?";
    private static Logger log = LogManager.getLogger(Menu.class.getName());

    public MenuDao(Connection connection) {
        this.connection = connection;
    }

    public String getGetAllFromMenu() {
        return getAllFromMenu;
    }

    public String getGetAllFromMenuWithId() {
        return getAllFromMenuWithId;
    }

    public String getInsertIntoMenu() {
        return insertIntoMenu;
    }

    public String getUpdateMenu() {
        return updateMenu;
    }

    public String getDeleteFromMenu() {
        return deleteFromMenu;
    }

    public String getGetMenuFromActiveRestaurants() {
        return getMenuFromActiveRestaurants;
    }

    @Override
    public List<Menu> getAllMenu() {
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromMenu());
            return this.getMenuList(ps);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public Menu getMenuByID(int id) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromMenuWithId());
            ps.setInt(1, id);
            ResultSet rez = ps.executeQuery();
            if (rez.next()) {
                return new Menu(rez.getInt("ID"), rez.getString("Name"), rez.getBoolean("isActive"), rez.getInt("restaurant_id"));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public void createMenu(Menu menu) {
        try {
            psSet(menu, menu.getRestaurantID(), getInsertIntoMenu());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void updateMenu(int id, Menu menu) {
        try {
            psSet(menu, id, getUpdateMenu());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public String deleteMenu(int id) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getDeleteFromMenu());
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Menu deleted";
        } catch (SQLException ex) {
            log.error("Error" + ex.getMessage());
            return "Menu removed";
        }
    }

    @Override
    public List<Menu> restaurantMenu(Restaurant restaurant) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetMenuFromActiveRestaurants());
            ps.setInt(1, restaurant.getId());
            ps.setBoolean(2, restaurant.isActive());
            return this.getMenuList(ps);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
    private PreparedStatement createPreparedStatement(String query) throws SQLException{
       return connection.prepareStatement(query);
    }
    private List<Menu> getMenuList(PreparedStatement ps) throws SQLException{
        ResultSet rez = ps.executeQuery();
        List<Menu> listaMenija = new ArrayList<>();
        if (rez.next()) {
            listaMenija.add(new Menu(rez.getInt("ID"), rez.getString("Name"), rez.getBoolean("isActive"), rez.getInt("restaurant_id")));
        }
        return listaMenija;
    }
    private void psSet (Menu menu, int id, String query) throws SQLException{
        PreparedStatement ps = this.createPreparedStatement(query);
        ps.setString(1, menu.getName());
        ps.setBoolean(2, menu.isActive());
        ps.setInt(3, id);
        ps.executeUpdate();
    }
}
