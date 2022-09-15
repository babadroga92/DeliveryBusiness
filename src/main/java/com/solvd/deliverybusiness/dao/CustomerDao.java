package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    private Connection connection;
    private static Logger log = LogManager.getLogger(CustomerDao.class.getName());


    public CustomerDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Customer> getAll() {
        List<Customer> listaMusterija = new ArrayList<>();
        String query = "Select * from Customer";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                    listaMusterija.add(new Customer(rez.getInt("ID"), rez.getString("fullName"),
                            rez.getString("address"), rez.getInt("city")));
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaMusterija;
    }

    @Override
    public Customer getByID(int id) {
            try {
                String query = "Select * from Customer where ID=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new Customer(rs.getInt("ID"), rs.getString("fullName"), rs.getString("address"), rs.getInt("city"));
                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
        return null;
    }

    @Override
    public void create(Customer customer) {
        try {
            String query = "Insert into Customer(fullName, address, city) values(?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getAddress());
            ps.setInt(3, customer.getCity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Customer customer) {
        try {
            String query = "Update Customer set fullName=? where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFullName());
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
                String query = "Delete from Customer where ID=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                return "Customer deleted";
            }
            catch (SQLException ex) {
                log.error("Error" + ex.getMessage());
                return "Customer removed";
            }
    }
}
