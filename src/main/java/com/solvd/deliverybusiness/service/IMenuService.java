package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IMenuService {
    public List<Menu> getAllMenu();
    public Menu getMenuByID(int id);
    public void createMenu(Menu menu);
    public void updateMenu(int id, Menu menu);
    public String deleteMenu(int id);
    public List<Menu> restaurantMenu(Restaurant restaurant);
}
