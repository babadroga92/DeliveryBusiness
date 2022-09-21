package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    private Connection connection;
    private static Logger log = LogManager.getLogger(CustomerDao.class.getName());
    private String getAllFromOrder = "Select * from deliverybusiness.Order";
    private String getAllFromOrderWithId = "Select * from deliverybusiness.Order where ID=?";
    private String insertIntoOrder = "Insert into deliverybusiness.Order" +
            "(orderDate, isPaid, price, preparedDate,takenOverDate, note, restaurant_ID, " +
            "customer_ID, coupons_ID, orderStatus_ID) values(?,?,?,?,?,?,?,?,?,?)";
    private String updateOrder = "Update deliverybusiness.Order set Price=? where ID=?";
    private String deleteOrder = "Delete from deliverybusiness.Order where ID=?";
    private String getOrderFromCustomer = "Select o.price, o.note, c.fullName, c.address from deliverybusiness.Order o" +
            " join deliverybusiness.Customer c on o.Customer_ID=c.ID where Customer_ID=1";

    private String getOrderFromRestaurant = "Select o.Price, o.Note, r.Name from deliverybusiness.Order o " +
            "join deliverybusiness.restaurant r on o.restaurant_ID=r.ID where restaurant_ID=?";

    public OrderDao() {
    }

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public String getGetAllFromOrder() {
        return getAllFromOrder;
    }

    public String getGetAllFromOrderWithId() {
        return getAllFromOrderWithId;
    }

    public String getInsertIntoOrder() {
        return insertIntoOrder;
    }

    public String getUpdateOrder() {
        return updateOrder;
    }

    public String getDeleteOrder() {
        return deleteOrder;
    }

    public String getGetOrderFromCustomer() {
        return getOrderFromCustomer;
    }

    public String getGetOrderFromRestaurant() {
        return getOrderFromRestaurant;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> listaNarudzbe = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetAllFromOrder());
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
        return listaNarudzbe;
    }

    @Override
    public Order getOrderByID(int id) {
        {
            try {
                PreparedStatement ps = this.createPreparedStatement(getGetAllFromOrderWithId());
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new Order(rs.getInt("ID"), rs.getDate("orderDate"), rs.getDate("preparedDate"),
                            rs.getDate("takenOverDate"), rs.getBoolean("isPaid"), rs.getDouble("price"),
                            rs.getString("note"), null, null, 0, 0);

                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public void createOrder(Order order) {
        try {
            psSet(order, order.getId(), getInsertIntoOrder());
           /* PreparedStatement ps = this.createPreparedStatement(getInsertIntoOrder());
            ps.setDate(1, Date.valueOf("2022-01-10"));
            ps.setBoolean(2, order.isPaid());
            ps.setDouble(3, order.getPrice());
            ps.setDate(4, Date.valueOf("2022-01-10"));
            ps.setDate(5, Date.valueOf("2022-01-10"));
            ps.setString(6, "note");
            ps.setInt(7, order.getRestaurant().getID());
            ps.setInt(8, order.getCustomer().getID());
            ps.setInt(9, order.getCouponsID());
            ps.setInt(10, order.getOrderStatusID());
            ps.executeUpdate(); */
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void updateOrder(int id, Order order) {
        try {
            PreparedStatement ps = this.createPreparedStatement(getUpdateOrder());
            ps.setDouble(1, order.getPrice());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }

    }

    @Override
    public String deleteOrder(int id) {
            try {
                PreparedStatement ps = this.createPreparedStatement(getDeleteOrder());
                ps.setInt(1, id);
                ps.executeUpdate();
                return "Order deleted";
            } catch (SQLException ex) {
                log.error("Error" + ex.getMessage());
                return "Order removed";
            }
    }

    @Override
    public List<Order> orderHistoryCustomer(Customer customer) {
        List<Order> listaNarudzbe = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetOrderFromCustomer());
            ResultSet rez = ps.executeQuery();
            while (rez.next()) {
                listaNarudzbe.add(new Order(0, null, null, null,
                        false, rez.getDouble("price"), rez.getString("note"),
                        null, new Customer(0, rez.getString("fullName"), rez.getString("address"), 0), 0, 0));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return listaNarudzbe;
    }

    @Override
    public List<Order> orderHistoryRestaurant(Restaurant restaurant) {
        List<Order> listaNarudzbe = new ArrayList<>();
        try {
            PreparedStatement ps = this.createPreparedStatement(getGetOrderFromRestaurant());
            ps.setInt(1, restaurant.getId());
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
        return listaNarudzbe;
    }
    private PreparedStatement createPreparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
    private void psSet (Order order, int id, String query) throws SQLException{
        PreparedStatement ps = this.createPreparedStatement(query);
        ps.setDate(1, Date.valueOf("2022-01-10"));
        ps.setBoolean(2, order.isPaid());
        ps.setDouble(3, order.getPrice());
        ps.setDate(4, Date.valueOf("2022-01-10"));
        ps.setDate(5, Date.valueOf("2022-01-10"));
        ps.setString(6, "note");
        ps.setInt(7, order.getRestaurant().getId());
        ps.setInt(8, order.getCustomer().getId());
        ps.setInt(9, order.getCouponsID());
        ps.setInt(10, order.getOrderStatusID());
        ps.executeUpdate();
    }
}
