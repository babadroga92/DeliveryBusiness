package com.solvd.deliverybusiness.service;

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
    public List<Menu> getAllMenu() {
        return this.menuDao.getAllMenu();
    }

    @Override
    public Menu getMenuByID(int id) {
        return this.menuDao.getMenuByID(id);
    }

    @Override
    public void createMenu(Menu menu) {
        this.menuDao.createMenu(menu);
    }

    @Override
    public void updateMenu(int id, Menu menu) {
        this.menuDao.updateMenu(id, menu);

    }

    @Override
    public String deleteMenu(int id) {

        return this.menuDao.deleteMenu(id);
    }

    @Override
    public List<Menu> restaurantMenu(Restaurant restaurant) {

        return this.menuDao.restaurantMenu(restaurant);
    }
}
