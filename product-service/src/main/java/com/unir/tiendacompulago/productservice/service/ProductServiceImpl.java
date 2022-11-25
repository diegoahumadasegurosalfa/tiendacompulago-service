package com.unir.tiendacompulago.productservice.service;

import java.util.Date;
import java.util.List;

import com.unir.tiendacompulago.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.unir.tiendacompulago.productservice.entity.Category;
import com.unir.tiendacompulago.productservice.entity.Product;
import com.unir.tiendacompulago.productservice.repository.ProductRepository;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public List<Product> listAllProduct(){
		return productRepository.findAll();
	}
	
	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		Category category = categoryRepository.findByname(product.getCategory().getName());
		if(category == null){
			categoryRepository.save(product.getCategory());
		}
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB =getProduct(product.getId());
		if (null == productDB) {
			return null;
		}
		productDB.setModel(product.getModel());
		productDB.setMaker(product.getMaker());
		productDB.setProcessor(product.getProcessor());
		productDB.setMemory(product.getMemory());
		productDB.setHdd(product.getHdd());
		productDB.setSsd(product.getSsd());
		productDB.setScreen(product.getScreen());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB =getProduct(id);
		if (null == productDB) {
			return null;
		}
		productDB.setStatus("DELETED");
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB =getProduct(id);
		if (null == productDB) {
			return null;
		}
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productRepository.save(productDB);
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> listAllCategory() { return categoryRepository.findAll(); }

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
}