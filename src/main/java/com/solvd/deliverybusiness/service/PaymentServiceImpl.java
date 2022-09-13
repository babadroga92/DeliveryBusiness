package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.dao.PaymentDao;
import com.solvd.deliverybusiness.dao.RestaurantDao;
import com.solvd.deliverybusiness.model.Payment;

import java.util.List;

public class PaymentServiceImpl implements IPaymentService{
    private PaymentDao paymentDao;

    public PaymentServiceImpl(RestaurantDao restaurantDao) {
        this.paymentDao= paymentDao;
    }


    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public List<Payment> getAllByCustomer(String customer) {
        return null;
    }

    @Override
    public Payment getByID(int id) {
        return null;
    }

    @Override
    public void create(Payment payment) {

    }

    @Override
    public void update(int id, Payment payment) {

    }

    @Override
    public String delete(int id) {
        return null;
    }
}
