package com.unir.tiedacompulago.customerservice.service;

import com.unir.tiedacompulago.customerservice.entity.Customer;

public interface CustomerService {
    //public List<Customer> listAllCustomer();
    public Customer getCustomer (Long id);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Long id);
}
