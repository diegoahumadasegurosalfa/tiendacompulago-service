package com.unir.tiendacompulago.shoppingservice.domain;

import lombok.Data;

@Data
public class Customer {

    private Long id;

    private String numberId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private Region region;

    private String state;
}
