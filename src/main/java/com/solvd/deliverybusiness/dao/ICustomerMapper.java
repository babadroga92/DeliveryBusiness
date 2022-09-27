package com.solvd.deliverybusiness.dao;

import com.solvd.deliverybusiness.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICustomerMapper {

    final String deleteFromCustomer = "Delete from Customer where ID=#{id}";
    final String getAllCustomers = "Select * from Customer";

    final String updateCustomer = "Update Customer set FullName= #{fullName} where ID= #{id}";

    final String getById = "Select * from Customer WHERE ID = #{id}";

    final String insertIntoCustomer = "Insert into Customer (FullName, Address) values (#{fullName},#{address})";

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "fullName", column = "FullName"),
            @Result(property = "address", column = "Address"),

    })
    Customer getById(int id);

    @Select(getAllCustomers)
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "fullName", column = "FullName"),
            @Result(property = "address", column = "Address")
    })
    List<Customer> getAllCustomers();

    @Insert(insertIntoCustomer)
    void insert(Customer customer);

    @Update(updateCustomer)
    void updateCustomer(@Param("fullName") String FullName, @Param("id") int id);

    @Delete(deleteFromCustomer)
    public void deleteFromCustomer(int id);

}
