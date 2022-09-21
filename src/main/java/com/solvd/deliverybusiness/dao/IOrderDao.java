package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IOrderDao {
    public List<Order> getAllOrders();
    public Order getOrderByID(int id);
    public void createOrder(Order order);
    public void updateOrder(int id, Order order);
    public String deleteOrder(int id);
    public List<Order> orderHistoryCustomer(Customer customer);
    public List<Order> orderHistoryRestaurant(Restaurant restaurant);


}
