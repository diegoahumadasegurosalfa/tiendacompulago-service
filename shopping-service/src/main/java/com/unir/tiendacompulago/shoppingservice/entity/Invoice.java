package com.unir.tiendacompulago.shoppingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unir.tiendacompulago.shoppingservice.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table (name="tbl_invoices")
@AllArgsConstructor @NoArgsConstructor
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
    private Date createAt;

    @Valid
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_id")
    private List<InvoiceItem> items;

    private String state;

    @Transient
    private Customer customer;

    @PrePersist
    public void prePersist(){ this.createAt=new Date(); }
}
