package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Payment;

import java.util.List;

public interface IPaymentService {
    public List<Payment> getAllPayments();
    public List<Payment> getAllPaymentsByCustomer(String customer);
    public Payment getPaymentByID(int id);
    public void createPayment(Payment payment);
    public void updatePayment(int id, Payment payment);
    public String deletePayment(int id);
}
