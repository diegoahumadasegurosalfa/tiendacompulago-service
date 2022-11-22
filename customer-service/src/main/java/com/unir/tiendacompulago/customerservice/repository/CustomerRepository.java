package com.unir.tiendacompulago.customerservice.repository;

import com.unir.tiendacompulago.customerservice.entity.Customer;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository <Customer,Long> {

    public List<Customer> findByName(Name name);

}
