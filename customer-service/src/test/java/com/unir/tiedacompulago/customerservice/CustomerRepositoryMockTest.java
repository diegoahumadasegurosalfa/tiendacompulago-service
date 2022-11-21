package com.unir.tiedacompulago.customerservice;

import com.unir.tiedacompulago.customerservice.entity.Customer;
import com.unir.tiedacompulago.customerservice.repository.CustomerRepository;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CustomerRepositoryMockTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void whenFindByName_thenResturnListCustomer(){
        Customer customer01 = Customer.builder()
                .name("Diego")
                .surname("Torres")
                .phone("3194740165")
                .direction("Bogota").build();

        customerRepository.save(customer01);



        // List<Customer> founds= customerRepository.findByName(customer01.getCustomer()); Assertions.assertThat(founds.size()).isEqualTo(4);

    }
}
