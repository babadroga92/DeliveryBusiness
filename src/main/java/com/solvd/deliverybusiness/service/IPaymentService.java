package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Payment;

import java.util.List;

public interface IPaymentService {
    public List<Payment> getAll();
    public List<Payment> getAllByCustomer(String customer);
    public Payment getByID(int id);
    public void create(Payment payment);
    public void update(int id, Payment payment);
    public String delete(int id);
}
