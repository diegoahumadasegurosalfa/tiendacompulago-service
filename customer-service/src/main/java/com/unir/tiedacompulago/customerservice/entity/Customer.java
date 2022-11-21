package com.unir.tiedacompulago.customerservice.entity;

import lombok.*;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_customer")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder

public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String phone;
    private String direction;

    public void setStatus(String created) {
    }

    public void setCreateAt(Date date) {
    }

    //public Name getCustomer() {     }
}


