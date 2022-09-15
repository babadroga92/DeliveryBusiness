package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao{
    private Connection connection;
    private static Logger log = LogManager.getLogger(CustomerDao.class.getName());

    public OrderDao() {
    }

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Order> getAll() {
        List<Order> listaNarudzbe = new ArrayList<>();
        String query = "Select * from deliverybusiness.Order";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try {
                ResultSet rez = ps.executeQuery();

                    while (rez.next()) {
                    listaNarudzbe.add(new Order(rez.getInt("ID"), rez.getDate("orderDate"),
                            rez.getDate("preparedDate"), rez.getDate("takenOverDate"),
                            rez.getBoolean("isPaid"),
                            rez.getDouble("price"),
                            rez.getString("note"), null, null, 0, 0));
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaNarudzbe;
    }
    @Override
    public Order getByID(int id) {
        {
            try {
                String query = "Select * from deliverybusiness.Order where ID=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                    return new Order(rs.getInt("ID"), rs.getDate("orderDate"), rs.getDate("preparedDate"),
                            rs.getDate("takenOverDate"), rs.getBoolean("isPaid"),rs.getDouble("price"),
                            rs.getString("note"), null, null, 0, 0);

                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public void create(Order order) {
        try {

            String query = "Insert into deliverybusiness.Order" +
                    "(orderDate, isPaid, price, preparedDate,takenOverDate, note, restaurant_ID, " +
                    "customer_ID, coupons_ID, orderStatus_ID) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, Date.valueOf("2022-01-10"));
            ps.setBoolean(2, order.isPaid());
            ps.setDouble(3, order.getPrice());
            ps.setDate(4, Date.valueOf("2022-01-10"));
            ps.setDate(5, Date.valueOf("2022-01-10"));
            ps.setString(6,"note");
            ps.setInt(7,order.getRestaurant().getID());
            ps.setInt(8,order.getCustomer().getID());
            ps.setInt(9,order.getCouponsID());
            ps.setInt(10,order.getOrderStatusID());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Order order) {
        try {
            String query = "Update deliverybusiness.Order set Price=? where ID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1,order.getPrice());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }

    }

    @Override
    public String delete(int id) {
        {
            try {

                String query = "Delete from deliverybusiness.Order where ID=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                return "Order deleted";
            } catch (SQLException ex) {
                log.error("Error" + ex.getMessage());
                return "Order removed";
            }
        }
    }

    @Override
    public List<Order> orderHistoryCustomer(Customer customer) {

            List<Order> listaNarudzbe = new ArrayList<>();
            String query = "Select o.price, o.note, c.fullName, c.address from deliverybusiness.Order o" +
                    " join deliverybusiness.Customer c on o.Customer_ID=c.ID where Customer_ID=1";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                try {
                    ResultSet rez = ps.executeQuery();

                        while (rez.next()) {
                        listaNarudzbe.add(new Order(0, null, null, null,
                                false, rez.getDouble("price"), rez.getString("note"),
                                null, new Customer(0, rez.getString("fullName"), rez.getString("address"),0),0,0));
                    }
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
            return listaNarudzbe;
        }
    @Override
    public List<Order> orderHistoryRestaurant(Restaurant restaurant) {
        List<Order> listaNarudzbe = new ArrayList<>();
        String query = "Select o.Price, o.Note, r.Name from deliverybusiness.Order o " +
                "join deliverybusiness.restaurant r on o.restaurant_ID=r.ID where restaurant_ID=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,restaurant.getID());
            try {
                ResultSet rez = ps.executeQuery();

                    while (rez.next()) {
                    listaNarudzbe.add(new Order(null, null,
                            null, false,
                             rez.getDouble("price"), rez.getString("Note"),
                            new Restaurant(0, rez.getString("Name"), false, "description", 1),
                            new Customer(0, "Ceca Raznatovic", "Otokara Kersovanija 81", 1),
                             1, 1));
                }

            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return listaNarudzbe;
    }
}
