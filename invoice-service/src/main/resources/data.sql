INSERT INTO tbl_invoices (id, number_invoice, description, customer_id, create_At, state) VALUES(1,'001','Factura venta',18467000,NOW(),'PAGADA');

INSER INTO tbl_invoices_items (invoice_id, product_id, quantity, price) VALUES(1,2,1,2800000);
INSER INTO tbl_invoices_items (invoice_id, product_id, quantity, price) VALUES(1,4,2,2500000);
INSER INTO tbl_invoices_items (invoice_id, product_id, quantity, price) VALUES(1,5,1,1700000);
