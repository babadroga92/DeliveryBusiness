package com.solvd.deliverybusiness.service;


import com.solvd.deliverybusiness.dao.OrderDao;
import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAll() {

        return this.orderDao.getAll();
    }

    @Override
    public Order getByID(int id) {
        return null;
    }

    @Override
    public void create(Order order) {
        this.orderDao.create(order);
    }

    @Override
    public void update(int id, Order order) {

    }

    @Override
    public String delete(int id) {

        return this.orderDao.delete(id);
    }

    @Override
    public List<Order> orderHistoryCustomer(Customer customer) {
        return this.orderDao.orderHistoryCustomer(customer);
    }

    @Override
    public List<Order> orderHistoryRestaurant(Restaurant restaurant) {
        return this.orderDao.orderHistoryRestaurant(restaurant);
    }
}
