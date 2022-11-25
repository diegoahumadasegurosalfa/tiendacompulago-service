package com.unir.tiendacompulago.shoppingservice.client;

import com.unir.tiendacompulago.shoppingservice.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", path = "/customers")
//@RequestMapping("/customers")
public interface CustomerClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id);
}
