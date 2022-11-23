package com.unir.tiendacompulago.shoppingservice.domain;

import lombok.Data;


@Data
public class Product {
    private Long id;

    private String modelo;

    private String marca;

    private String procesador;

    private String memoria;

    private String hhdd;

    private String ssd;

    private String pantalla;

    private Double stock;

    private Double precio;

    private String status;

    private Category category;

}
