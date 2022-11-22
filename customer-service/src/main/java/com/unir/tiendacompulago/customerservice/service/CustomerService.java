package com.unir.tiendacompulago.customerservice.service;

import com.unir.tiendacompulago.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> listAllCustomer();
    public Customer getCustomer (Long id);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Long id);
}
