package com.unir.tiendacompulago.productservice.service;

import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.unir.tiendacompulago.productservice.entity.Category;
import com.unir.tiendacompulago.productservice.entity.Product;
import com.unir.tiendacompulago.productservice.repository.ProductRepository;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
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
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB =getProduct(product.getId());
		if (null == productDB) {
			return null;
		}
		productDB.setModelo(product.getModelo());
		productDB.setMarca(product.getMarca());
		productDB.setProcesador(product.getProcesador());
		productDB.setMemoria(product.getMemoria());
		productDB.setHhdd(product.getHhdd());
		productDB.setSsd(product.getSsd());
		productDB.setPantalla(product.getPantalla());
		productDB.setCategory(product.getCategory());
		productDB.setPrecio(product.getPrecio());
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
}