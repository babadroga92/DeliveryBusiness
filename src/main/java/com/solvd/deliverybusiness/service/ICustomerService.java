package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.exception.InvalidIDException;
import com.solvd.deliverybusiness.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomerByID(int id) throws InvalidIDException;
    public void createCustomer(Customer customer) throws DatabaseException;
    public void updateCustomer(int id, Customer customer) throws InvalidIDException, DatabaseException;
    public String deleteCustomer(int id) throws DatabaseException;
}
