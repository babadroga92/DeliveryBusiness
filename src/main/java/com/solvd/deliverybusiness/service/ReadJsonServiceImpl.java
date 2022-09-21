package com.solvd.deliverybusiness.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.deliverybusiness.model.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJsonServiceImpl implements IReadJson {
    @Override
    public void readCityJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<City> cityList = objectMapper.readValue(new File(path), new TypeReference<List<City>>() {
        });
        cityList.forEach(s -> System.out.println(s));
    }

    @Override
    public void readOrderJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> orderList = objectMapper.readValue(new File(path), new TypeReference<List<Order>>() {
        });
        orderList.forEach(s -> System.out.println(s));

    }

    @Override
    public void readMenuJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Menu> menuList = objectMapper.readValue(new File(path), new TypeReference<List<Menu>>() {
        });
        menuList.forEach(s -> System.out.println(s));
    }

    @Override
    public void readCustomerJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customerList = objectMapper.readValue(new File(path), new TypeReference<List<Customer>>() {
        });
        customerList.forEach(s -> System.out.println(s));
    }

    @Override
    public void readRestaurantJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Restaurant> restaurantList = objectMapper.readValue(new File(path), new TypeReference<List<Restaurant>>() {
        });
        restaurantList.forEach(s -> System.out.println(s));
    }
}
