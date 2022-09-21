package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    private Connection connection;

    private String getAllCustomers = "Select * from Customer";

    private String getAllCustomersWithId = "Select * from Customer where ID=?";

    private String insertIntoCustomer = "Insert into Customer(fullName, address, city) values(?,?,?) ";

    private String updateCustomer = "Update Customer set fullName=? where ID=?";

    private String deleteFromCustomer = "Delete from Customer where ID=?";
    private static Logger log = LogManager.getLogger(CustomerDao.class.getName());

    public String getGetAllCustomers() {
        return getAllCustomers;
    }

    public String getGetAllCustomersWithId() {
        return getAllCustomersWithId;
    }

    public String getInsertIntoCustomer() {
        return insertIntoCustomer;
    }

    public String getUpdateCustomer() {
        return updateCustomer;
    }

    public String getDeleteFromCustomer() {
        return deleteFromCustomer;
    }

    public CustomerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> listaMusterija = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllCustomers());
            ResultSet rez = ps.executeQuery();
            while (rez.next()) {
                listaMusterija.add(new Customer(rez.getInt("ID"), rez.getString("fullName"),
                        rez.getString("address"), rez.getInt("city")));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaMusterija;
    }

    @Override
    public Customer getCustomerByID(int id) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllCustomersWithId());
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
    public void createCustomer(Customer customer) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getInsertIntoCustomer());
            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getAddress());
            ps.setInt(3, customer.getCity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        try {
            PreparedStatement ps =this.createPreparedStatement(getUpdateCustomer());
            ps.setString(1, customer.getFullName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public String deleteCustomer(int id) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getDeleteFromCustomer());
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Customer deleted";
        } catch (SQLException ex) {
            log.error("Error" + ex.getMessage());
            return "Customer removed";
        }
    }
    private PreparedStatement createPreparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
}
