package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IOrderService {
    public List<Order> getAll();
    public Order getByID(int id);
    public void create(Order order);
    public void update(int id, Order order);
    public String delete(int id);
    public List<Order> orderHistoryCustomer(Customer customer);
    public List<Order> orderHistoryRestaurant(Restaurant restaurant);
}
