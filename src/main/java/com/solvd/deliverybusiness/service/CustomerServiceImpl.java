package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.dao.CustomerDao;
import com.solvd.deliverybusiness.exception.DatabaseException;
import com.solvd.deliverybusiness.exception.InvalidIDException;
import com.solvd.deliverybusiness.model.Customer;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{



    private CustomerDao customerDao;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerByID(int id) throws InvalidIDException {
        if(id<1) {
            throw new InvalidIDException("ID must be higher than 0.");
        }
            return this.customerDao.getCustomerByID(id);
    }

    @Override
    public void createCustomer(Customer customer) throws DatabaseException {
        if (customer.getFullName()== null || customer.getAddress()==null)  {
            throw new DatabaseException("Error with fullName or address");
        }
        this.customerDao.createCustomer(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws InvalidIDException, DatabaseException {
        if(id<1){
            throw new InvalidIDException("Error with ID");
        } else if (customer.getFullName()== null || customer.getAddress()==null)  {
            throw new DatabaseException("Error with fullName and address");

        }
            this.customerDao.updateCustomer(id, customer);
    }

    @Override
    public String deleteCustomer(int id) throws DatabaseException {
        if(id<1) {
            throw new DatabaseException("Error");
        }
            return this.customerDao.deleteCustomer(id);
    }
}
