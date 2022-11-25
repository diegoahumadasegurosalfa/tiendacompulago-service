package com.unir.tiendacompulago.shoppingservice.service;

import com.unir.tiendacompulago.shoppingservice.client.CustomerClient;
import com.unir.tiendacompulago.shoppingservice.client.ProductClient;
import com.unir.tiendacompulago.shoppingservice.entity.Invoice;
import com.unir.tiendacompulago.shoppingservice.entity.InvoiceItem;
import com.unir.tiendacompulago.shoppingservice.domain.Customer;
import com.unir.tiendacompulago.shoppingservice.domain.Product;
import com.unir.tiendacompulago.shoppingservice.repository.InvoiceItemsRepository;
import com.unir.tiendacompulago.shoppingservice.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    ProductClient productClient;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
        public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getNumberInvoice());
        if (invoiceDB !=null){
            return invoiceDB;
        }
        invoice.setState("CREATED");
        invoiceDB = invoiceRepository.save(invoice);
        invoiceDB.getItems().forEach(invoiceItem -> {
            productClient.updateStockProduct(invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
        });
        return invoiceDB;
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getNumberInvoice());
        if (invoiceDB == null){
            return null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getNumberInvoice());
        if (invoiceDB == null) {
            return null;
        }
        invoiceDB.setState("DELETED");
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice getInvoice(String numberInvoice) {
        Invoice invoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        if(invoice != null){
            Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody();
            invoice.setCustomer(customer);
            List<InvoiceItem> listItem = invoice.getItems().stream().map(invoiceItem -> {
                Product product = productClient.getProduct(invoiceItem.getProductId()).getBody();
                invoiceItem.setProduct(product);
                return invoiceItem;
            }).collect(Collectors.toList());

            invoice.setItems(listItem);
        }
        return invoice;
    }
}
