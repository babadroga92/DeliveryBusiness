package com.solvd.deliverybusiness.dao;
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

    private String getAllFromPayment = "Select * from Payment";

    private String insertIntoPayment = "Insert into Payment(Amount) values(?) ";

    private String updatePayment = "Update Payment set Amount=? where ID=?";

    private static Logger log = LogManager.getLogger(PaymentDao.class.getName());

    public PaymentDao(Connection connection) {
        this.connection = connection;
    }

    public String getGetAllFromPayment() {
        return getAllFromPayment;
    }

    public String getInsertIntoPayment() {
        return insertIntoPayment;
    }

    public String getUpdatePayment() {
        return updatePayment;
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> listaRacuna = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromPayment());
                ResultSet rez = ps.executeQuery();
                while (rez.next()) {
                    listaRacuna.add(new Payment(rez.getInt("ID"), rez.getDouble("Amount"), rez.getInt("Customer_ID")));
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        return listaRacuna;
    }

    @Override
    public List<Payment> getAllPaymentsByCustomer(String customer) {
        return null;
    }

    @Override
    public Payment getPaymentByID(int id) {
        return null;
    }

    @Override
    public void createPayment(Payment payment) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getInsertIntoPayment());
            ps.setDouble(1, payment.getAmount());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            log.error(ex.getMessage());
        }


    }

    @Override
    public void updatePayment(int id, Payment payment) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getUpdatePayment());
            ps.setDouble(1,payment.getAmount());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public String deletePayment(int id) {
        return null;
    }

    private PreparedStatement createPreparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
}
