package com.solvd.deliverybusiness.dao;
import com.solvd.deliverybusiness.model.Payment;
import java.util.List;

public interface IPaymentDao {
    public List<Payment> getAll();
    public List<Payment> getAllByCustomer(String customer);
    public Payment getByID(int id);
    public void create(Payment payment);
    public void update(int id, Payment payment);
    public String delete(int id);


}
