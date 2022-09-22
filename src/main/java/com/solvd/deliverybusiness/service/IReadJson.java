package com.solvd.deliverybusiness.service;
import java.io.IOException;

public interface IReadJson {
    public <T> T convertGenericJson(String path,  Class<?> target) throws IOException, ClassNotFoundException;

    public void readCityJson(String path) throws IOException;
    public void readOrderJson(String path) throws IOException;
    public void readMenuJson(String path) throws IOException;
    public void readCustomerJson(String path) throws IOException;
    public void readRestaurantJson(String path) throws IOException;
}
