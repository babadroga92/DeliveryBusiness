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
    public List<Order> getAllOrders() {

        return this.orderDao.getAllOrders();
    }

    @Override
    public Order getOrderByID(int id) {
        return this.orderDao.getOrderByID(id);
    }

    @Override
    public void createOrder(Order order) {
        this.orderDao.createOrder(order);
    }

    @Override
    public void updateOrder(int id, Order order) {
        this.orderDao.updateOrder(id, order);
    }

    @Override
    public String deleteOrder(int id) {

        return this.orderDao.deleteOrder(id);
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
