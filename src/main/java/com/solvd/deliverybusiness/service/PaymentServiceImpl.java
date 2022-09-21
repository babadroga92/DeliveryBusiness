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
    public List<Payment> getAllPayments() {

        return this.paymentDao.getAllPayments();
    }

    @Override
    public List<Payment> getAllPaymentsByCustomer(String customer) {

        return this.paymentDao.getAllPaymentsByCustomer(customer);
    }

    @Override
    public Payment getPaymentByID(int id) {

        return paymentDao.getPaymentByID(id);
    }

    @Override
    public void createPayment(Payment payment) {
        this.paymentDao.createPayment(payment);
    }

    @Override
    public void updatePayment(int id, Payment payment) {
        this.paymentDao.updatePayment(id, payment);
    }

    @Override
    public String deletePayment(int id) {

        return this.paymentDao.deletePayment(id);
    }
}
