package com.unir.tiendacompulago.customerservice.service;

import com.unir.tiendacompulago.customerservice.entity.Customer;
import com.unir.tiendacompulago.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse( null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setStatus("CREATED");
        customer.setCreateAt(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = getCustomer(customer.getId());
        if (null == customerDB ){
            return null;
        }
        customerDB.setName(customer.getName());
        customerDB.setSurname(customer.getSurname());
        customerDB.setPhone(customer.getPhone());
        customerDB.setDirection(customer.getDirection());
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = getCustomer(id);
        if (null == customerDB ){
            return null;
        }
        customerDB.setStatus("DELETE");
        return customerRepository.save(customerDB);
    }
}
