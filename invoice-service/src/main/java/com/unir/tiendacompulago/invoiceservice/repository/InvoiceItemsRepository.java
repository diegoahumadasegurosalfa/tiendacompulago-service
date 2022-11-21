package com.unir.tiendacompulago.invoiceservice.repository;

import com.unir.tiendacompulago.invoiceservice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
}
