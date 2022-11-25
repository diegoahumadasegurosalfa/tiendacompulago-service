INSERT INTO tbl_invoices (number_invoice, description, customer_id, create_at, state) VALUES('001','Factura venta',1,NOW(),'PAGADA');

INSERT INTO tbl_invoice_items (invoice_id, product_id, quantity, price) VALUES(1, 1 , 1, 178.89);
INSERT INTO tbl_invoice_items (invoice_id, product_id, quantity, price) VALUES(1, 2 , 2, 12.5);
INSERT INTO tbl_invoice_items (invoice_id, product_id, quantity, price) VALUES(1, 3 , 1, 40.06);
