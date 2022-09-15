package com.solvd.deliverybusiness.dao;
import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IMenuDao {
    public List<Menu> getAll();
    public Menu getByID(int id);
    public void create(Menu menu);
    public void update(int id, Menu menu);
    public String delete(int id);
    public List<Menu> restaurantMenu(Restaurant restaurant);
}
