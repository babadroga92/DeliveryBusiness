package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.dao.CustomerDao;
import com.solvd.deliverybusiness.dao.MenuDao;
import com.solvd.deliverybusiness.model.Menu;
import com.solvd.deliverybusiness.model.Restaurant;

import java.util.List;

public class MenuServiceImpl implements IMenuService{
    private MenuDao menuDao;

    public MenuServiceImpl() {
    }

    public MenuServiceImpl(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> getAll() {
        return this.menuDao.getAll();
    }

    @Override
    public Menu getByID(int id) {
        return this.menuDao.getByID(id);
    }

    @Override
    public void create(Menu menu) {
        this.menuDao.create(menu);
    }

    @Override
    public void update(int id, Menu menu) {
        this.menuDao.update(id, menu);

    }

    @Override
    public String delete(int id) {
        return this.menuDao.delete(id);
    }

    @Override
    public List<Menu> restaurantMenu(Restaurant restaurant) {
        return this.menuDao.restaurantMenu(restaurant);
    }
}
