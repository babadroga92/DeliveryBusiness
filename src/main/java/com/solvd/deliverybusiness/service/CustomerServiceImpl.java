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
    public List<Customer> getAll() {
        return this.customerDao.getAll();
    }

    @Override
    public Customer getByID(int id) throws InvalidIDException {
        if(id<1) {
            throw new InvalidIDException("ID must be higher than 0.");
        }
            return this.customerDao.getByID(id);
    }

    @Override
    public void create(Customer customer) throws DatabaseException {
        if (customer.getFullName()== null || customer.getAddress()==null)  {
            throw new DatabaseException("Error with fullName or address");
        }
        this.customerDao.create(customer);
    }

    @Override
    public void update(int id, Customer customer) throws DatabaseException {
        if(id<1){
            throw new DatabaseException("Error with ID");
        } else if (customer.getFullName()== null || customer.getAddress()==null)  {
            throw new DatabaseException("Error with fullName and address");

        }
            this.customerDao.update(id, customer);
    }

    @Override
    public String delete(int id) throws DatabaseException {
        if(id<1) {
            throw new DatabaseException("Error");
        }
            return this.customerDao.delete(id);
    }
}
