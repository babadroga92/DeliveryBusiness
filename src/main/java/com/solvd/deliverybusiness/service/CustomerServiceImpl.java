package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.dao.CustomerDao;
import com.solvd.deliverybusiness.dao.ICustomerMapper;
import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.exception.InvalidIDException;
import com.solvd.deliverybusiness.model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {


    private CustomerDao customerDao;

    private ICustomerMapper maper;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(CustomerDao customerDao, ICustomerMapper maper) {
        this.customerDao = customerDao;
        this.maper = maper;
    }

    @Override
    public List<Customer> getAllCustomers() {
        if (this.customerDao != null) {
            return this.customerDao.getAllCustomers();
        } else {
            return this.maper.getAllCustomers();
        }
    }

    @Override
    public Customer getCustomerByID(int id) throws InvalidIDException {
        if (id < 1) {
            throw new InvalidIDException("ID must be higher than 0.");
        }
        if (this.customerDao != null) {
            return this.customerDao.getCustomerByID(id);
        } else {
            return this.maper.getById(id);
        }
    }

    @Override
    public void createCustomer(Customer customer) throws DatabaseException {
        if (customer.getFullName() == null || customer.getAddress() == null) {
            throw new DatabaseException("Error with fullName or address");
        }
        if (this.customerDao != null) {
            this.customerDao.createCustomer(customer);
        } else {
            this.maper.insert(customer);
        }
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws InvalidIDException, DatabaseException {
        if (id < 1) {
            throw new InvalidIDException("Error with ID");
        } else if (customer.getFullName() == null || customer.getAddress() == null) {
            throw new DatabaseException("Error with fullName and address");
        }
        if (this.customerDao != null) {
            this.customerDao.updateCustomer(id, customer);
        } else {
            this.maper.updateCustomer(customer.getFullName(), id);
        }
    }

    @Override
    public String deleteCustomer(int id) throws DatabaseException {
        if (id < 1) {
            throw new DatabaseException("Error");
        }
        if (this.customerDao != null) {
            return this.customerDao.deleteCustomer(id);
        } else {
            this.maper.deleteFromCustomer(id);
            return "success";
        }
    }
}
