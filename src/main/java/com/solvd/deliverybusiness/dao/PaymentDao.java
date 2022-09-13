package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao implements IPaymentDao{
    private Connection connection;

    private static Logger log = LogManager.getLogger(PaymentDao.class.getName());

    public PaymentDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Payment> getAll() {
        List<Payment> listaRacuna = new ArrayList<>();
        String query = "Select * from Payment";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                    listaRacuna.add(new Payment(rez.getInt("ID"), rez.getDouble("Amount"), rez.getInt("Customer_ID")));
                }

            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaRacuna;
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
        try {

            String query = "Insert into Payment(Amount) values(?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, payment.getAmount());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            log.error(ex.getMessage());
        }


    }

    @Override
    public void update(int id, Payment payment) {
        try {
            String query = "Update Payment set Amount=? where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1,payment.getAmount());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }

    }

    @Override
    public String delete(int id) {
        return null;
    }
}
