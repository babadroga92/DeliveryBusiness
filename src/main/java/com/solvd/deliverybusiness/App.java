package com.solvd.deliverybusiness;
import com.solvd.deliverybusiness.connection.DatabaseConnection;
import com.solvd.deliverybusiness.dao.*;
import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.exception.InvalidIDException;
import com.solvd.deliverybusiness.model.*;
import com.solvd.deliverybusiness.service.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class App {
    private static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        Customer customer = new Customer(5, "Dragana Mirkovic", "Mose Pijade 101", 1);
        Customer customerq = new Customer(5, "Mirjana", "Mose Pij1", 1);
        DatabaseConnection db = new DatabaseConnection();
        SqlSessionFactory konekcija;
            try {
                Configurator.setLevel(log.getName(), Level.INFO);
                konekcija = db.myBatisConnection();
                SqlSession session = konekcija.openSession(true);
                session.getConfiguration().addMapper(ICustomerMapper.class);
                ICustomerMapper maper = session.getMapper(ICustomerMapper.class);
                CustomerServiceImpl menadzerZaMusteriju = new CustomerServiceImpl(null, maper);
                List<Customer> listaMust = menadzerZaMusteriju.getAllCustomers();
                listaMust.forEach(s->log.info(s));
                menadzerZaMusteriju.updateCustomer(222, customerq);
                session.close();

            } catch (IOException e) {
                log.error(e.getMessage());
            } catch (InvalidIDException e) {
                throw new RuntimeException(e);
            } catch (DatabaseException e) {
                throw new RuntimeException(e);
            }
//    public static void main(String[] args) throws IOException, SAXException {
//        ReadJsonServiceImpl readJsonService = new ReadJsonServiceImpl();
//        readJsonService.readCityJson("src/main/resources/json/city.json");
//        XmlValidator xmlValidator = new XmlValidator();
//        xmlValidator.xsdXmlValidation("src/main/resources/xsd/menu.xsd","src/main/resources/xml/menu.xml");
//        xmlValidator.xsdXmlValidation("src/main/resources/xsd/restaurant.xsd","src/main/resources/xml/restaurant.xml");
//        Configurator.setLevel(log.getName(), Level.INFO);
//        Restaurant restaurant2 = new Restaurant(2, "Cas", true, "Srpski", 2);
//        Restaurant restaurant1 = new Restaurant(1, "Carrabas", true, "Italian", 1);
//        Restaurant restaurant3 = new Restaurant(3, "Novi Restoran", true, "Bosanski restoran", 3);
//        Customer customer = new Customer(1, "Dragana Mirkovic", "Mose Pijade 101", 1);
//        Customer customer1 = new Customer(2, "Milos Jovicic", "Mose Pijade 102", 2);
//        Order order = new Order(null, null, null, true,
//                11.99, "first order", restaurant1, customer, 1, 1);
//        Order order1 = new Order(null, null, null,
//                true, 10.99, "second order", restaurant1, customer1, 1, 1);
//        try {
//            DatabaseConnection connectDB = new DatabaseConnection();
//            BasicDataSource bs = connectDB.pollConnection();
//            Connection connection = bs.getConnection();
//            ReadJsonServiceImpl jsonService = new ReadJsonServiceImpl();
//            List<City> cityList = jsonService.convertGenericJson("src/main/resources/city.json", City.class);
//            cityList.forEach(s->System.out.println(s));
//            List<WeekDay> weekDayList = jsonService.convertGenericJson("src/main/resources/weekDay.json", WeekDay.class);
//            weekDayList.forEach(s->System.out.println(s));
//
//           Connection connection = connectDB.createConnection();
//            CustomerDao customerDao = new CustomerDao(connection);
//            CustomerServiceImpl menadzerZaMusteriju = new CustomerServiceImpl(customerDao);
//            MenuDao menuDao = new MenuDao(connection);
//            MenuServiceImpl menadzerZaMeni = new MenuServiceImpl(menuDao);
//            List<Menu> lista = menadzerZaMeni.restaurantMenu(restaurant1);
//            lista.stream().forEach(s -> log.info(s.getName()));
//            List<Customer> customerList = menadzerZaMusteriju.getAllCustomers();
//            customerList.stream().forEach(s -> log.info(s));
//            Customer customer2 = menadzerZaMusteriju.getCustomerByID(1);
//            String poruka = menadzerZaMusteriju.deleteCustomer(14);
//            log.info(poruka);
//            OrderDao orderDao = new OrderDao(connection);
//            OrderServiceImpl menadzerZaPorudzbinu = new OrderServiceImpl(orderDao);
//            menadzerZaPorudzbinu.createOrder(order);
//            menadzerZaPorudzbinu.createOrder(order1);
//            List<Order> orderList = menadzerZaPorudzbinu.getAllOrders();
//            String poruka1 = menadzerZaPorudzbinu.deleteOrder(12);
//            log.info(poruka1);
//            List<Order> listaZaRestoran = menadzerZaPorudzbinu.orderHistoryRestaurant(restaurant1);
//            RestaurantDao restaurantDao = new RestaurantDao(connection);
//            RestaurantServiceImpl menadzerZaRestorane = new RestaurantServiceImpl(restaurantDao);
//            menadzerZaRestorane.createRestaurant(restaurant3);
//            List<Restaurant> listaRestorana = menadzerZaRestorane.getAllRestaurants();
//            List<Restaurant> listaRestorana1 = menadzerZaRestorane.getAllRestaurantsFromCity("Novi Sad");
//            OrderServiceImpl menadzer1 = new OrderServiceImpl(orderDao);
//            List<Order> listaNarudzbi = menadzer1.orderHistoryCustomer(new Customer(1, null, null, 0));
//            listaNarudzbi.forEach(s -> log.info(s));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        try {
//            ReadCustomerXmlImpl readXml = new ReadCustomerXmlImpl("src/main/resources/xml/customer.xml");
//            readXml.readXml();
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        try {
//            ReadRestaurantXmlImpl restaurantXml = new ReadRestaurantXmlImpl("src/main/resources/xml/restaurant.xml");
//            restaurantXml.readXml();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//     }
    }
}

