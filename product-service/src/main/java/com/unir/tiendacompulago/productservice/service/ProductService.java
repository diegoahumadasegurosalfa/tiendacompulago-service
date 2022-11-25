package com.unir.tiendacompulago.productservice.service;

import java.util.List;

import com.unir.tiendacompulago.productservice.entity.Category;
import com.unir.tiendacompulago.productservice.entity.Product;



public interface ProductService {
	public List<Product> listAllProduct();
	public Product getProduct(Long id);
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(Long id);
	public List<Product> findByCategory(Category category);
	public Product updateStock(Long id, Double quantity);
	public Category createCategory(Category category);
	public List<Category> listAllCategory();
	public Category getCategory(Long id);
}
