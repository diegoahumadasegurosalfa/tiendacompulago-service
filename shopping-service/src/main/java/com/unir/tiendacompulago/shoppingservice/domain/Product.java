package com.unir.tiendacompulago.shoppingservice.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String model;
    private String maker;
    private String processor;
    private String memory;
    private String hdd;
    private String ssd;
    private String screen;

    private Double stock;
    private Double price;
    private String status;
    private Category category;
}
