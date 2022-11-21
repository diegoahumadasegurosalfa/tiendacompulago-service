package com.unir.tiendacompulago.invoiceservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.annotation.Contract;

import javax.validation.constraints.Positive;

import javax.persistence.*;

@Entity
@Contract
@Data
@Table (name="tbl_invoice_items")
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "El stock debe ser mayor que cero (0)")
    private Double quantity;
    private Double price;


    private Double subTotal;
    //private Product product;

    public Double getSubtotal() {
        if (this.price > 0 && this.quantity > 0) {
            return this.quantity * this.price;
        } else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
    this.quantity=(double) 0;
    this.price=(double) 0;
        }

}
