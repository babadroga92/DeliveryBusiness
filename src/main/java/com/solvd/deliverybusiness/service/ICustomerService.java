package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.exception.InvalidIDException;
import com.solvd.deliverybusiness.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAll();
    public Customer getByID(int id) throws InvalidIDException;
    public void create(Customer customer) throws DatabaseException;
    public void update(int id, Customer customer) throws InvalidIDException, DatabaseException;
    public String delete(int id) throws DatabaseException;
}
