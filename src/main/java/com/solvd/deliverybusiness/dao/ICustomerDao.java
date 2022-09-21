package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;

import java.util.List;

public interface ICustomerDao {
    public List<Customer> getAllCustomers();
    public Customer getCustomerByID(int id);
    public void createCustomer(Customer customer);
    public void updateCustomer(int id, Customer customer);
    public String deleteCustomer(int id);

}
