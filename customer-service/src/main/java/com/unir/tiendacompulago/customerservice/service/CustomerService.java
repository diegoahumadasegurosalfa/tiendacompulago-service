package com.unir.tiendacompulago.customerservice.service;

import com.unir.tiendacompulago.customerservice.entity.Customer;
import com.unir.tiendacompulago.customerservice.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomerAll();
    public Customer getCustomer(Long id);
    public List<Customer> findCustomerByRegion(Region region);
    public Customer findCustomerbyNumberId(String numberId);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);

}
