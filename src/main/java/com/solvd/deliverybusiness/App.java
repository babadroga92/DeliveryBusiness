package com.solvd.deliverybusiness;

import com.solvd.deliverybusiness.connection.DatabaseConnection;
import com.solvd.deliverybusiness.dao.CustomerDao;
import com.solvd.deliverybusiness.dao.MenuDao;
import com.solvd.deliverybusiness.dao.OrderDao;
import com.solvd.deliverybusiness.dao.RestaurantDao;
import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Order;
import com.solvd.deliverybusiness.model.Restaurant;
import com.solvd.deliverybusiness.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class App {
    private static Logger log = LogManager.getLogger(CustomerDao.class.getName());


    public static void main(String[] args) {

            XmlValidator xmlValidator = new XmlValidator();
            xmlValidator.validateCustomerXml();
            xmlValidator.validateRestaurantXml();
            xmlValidator.validatePaymentXml();
            xmlValidator.validateMenuXml();


            Restaurant restaurant2 = new Restaurant(2, "Cas", true, "Srpski", 2);
            Restaurant restaurant1 = new Restaurant(1, "Carrabas", true, "Italian", 1);
            Customer customer = new Customer(1, "Dragana Mirkovic", "Mose Pijade 101", 1);
            Customer customer1 = new Customer(2, "Milos Jovicic", "Mose Pijade 102", 2);
            Order order = new Order(null, null, null, true,
                    11.99, "first order", restaurant1, customer, 1, 1);
            Order order1 = new Order(null, null, null,
                    true, 10.99, "second order", restaurant1, customer1, 1, 1);

            try {
                DatabaseConnection connectDB = new DatabaseConnection();
                Connection connection = connectDB.createConnection();
                CustomerDao customerDao = new CustomerDao(connection);
                CustomerServiceImpl menadzerZaMusteriju = new CustomerServiceImpl(customerDao);
                menadzerZaMusteriju.create(customer1);

                MenuDao menuDao = new MenuDao(connection);
                MenuServiceImpl menadzerZaMeni = new MenuServiceImpl(menuDao);
               List<Menu> lista =  menadzerZaMeni.restaurantMenu(restaurant1);
               for(Menu menu : lista){
                   System.out.println(menu);
               }
                List<Customer> customerList = menadzerZaMusteriju.getAll();
                for (Customer musterija : customerList) {
                    System.out.println(musterija.getFullName() + musterija.getAddress());
                }
                Customer customer2 = menadzerZaMusteriju.getByID(1);
                System.out.println(customer2.getFullName());
                String poruka = menadzerZaMusteriju.delete(14);
                System.out.println(poruka);

                OrderDao orderDao = new OrderDao(connection);
                OrderServiceImpl menadzerZaPorudzbinu = new OrderServiceImpl(orderDao);
                menadzerZaPorudzbinu.create(order);
                menadzerZaPorudzbinu.create(order1);
                List<Order> orderList = menadzerZaPorudzbinu.getAll();
                for (Order narudzba : orderList) {
                    System.out.println(narudzba);
                }
                String poruka1 = menadzerZaPorudzbinu.delete(12);
                System.out.println(poruka1);


                List<Order> listaZaRestoran = menadzerZaPorudzbinu.orderHistoryRestaurant(restaurant1);
                for (Order order12 : listaZaRestoran) {
                    System.out.println(order12);
                }
                RestaurantDao restaurantDao = new RestaurantDao(connection);
                RestaurantServiceImpl menadzerZaRestorane = new RestaurantServiceImpl(restaurantDao);
                List<Restaurant> listaRestorana = menadzerZaRestorane.getAll();
                List<Restaurant> listaRestorana1 = menadzerZaRestorane.getAllFromCity("Novi Sad");
                for (Restaurant restaurant : listaRestorana) {
                    System.out.println(listaRestorana);
                }
                menadzerZaRestorane.create(restaurant1);
                menadzerZaRestorane.create(restaurant2);

                for (Restaurant restaurant : listaRestorana1) {
                    System.out.println("Restorani iz grada" + listaRestorana1);
                }


                OrderServiceImpl menadzer1 = new OrderServiceImpl(orderDao);
                List<Order> listaNarudzbi = menadzer1.orderHistoryCustomer(new Customer(1, null, null, 0));
                for (Order narudzba : listaNarudzbi) {
                    System.out.println(narudzba.getOrderDate() + " " + narudzba.getPrice() + narudzba.isPaid()
                            + narudzba.getNote() + narudzba.getCustomer().getFullName() + narudzba.getCustomer().getAddress());
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            try {
                ReadCustomerXmlImpl readXml = new ReadCustomerXmlImpl();
                readXml.readXml();

            } catch (Exception e) {
                log.error(e.getMessage());
            }
            try {
                ReadRestaurantXmlImpl restaurantXml = new ReadRestaurantXmlImpl();
                restaurantXml.readXml();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

