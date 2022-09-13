package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;

import java.util.List;

public interface ICustomerDao {
    public List<Customer> getAll();
    public Customer getByID(int id);
    public void create(Customer customer);
    public void update(int id, Customer customer);
    public String delete(int id);

}
