package com.unir.tiendacompulago.shoppingservice.repository;

import com.unir.tiendacompulago.shoppingservice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
}
