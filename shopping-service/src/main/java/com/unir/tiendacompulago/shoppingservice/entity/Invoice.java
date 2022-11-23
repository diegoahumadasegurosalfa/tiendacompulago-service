package com.unir.tiendacompulago.shoppingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unir.tiendacompulago.shoppingservice.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import io.micrometer.core.instrument.config.validate.Validated;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
//import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table (name="tbl_invoices")
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "number_invoice")
    private String numberInvoice;

    private String description;

    @Column(name="customer_id)")
    private Long customerId;

    @Column (name="create_at")
    @Temporal(TemporalType.DATE)
    private Date create_At;
    //@Valid
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_id")
    private List<InvoiceItem> items;

    private String state;

    @Transient
    private Customer customer;

    public Invoice() {
        items =new ArrayList<>();
    }
    @PrePersist
    public void prePersist(){this.create_At=new Date();}
}
