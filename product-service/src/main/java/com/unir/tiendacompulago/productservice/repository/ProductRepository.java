package com.unir.tiendacompulago.productservice.repository;

import java.util.List;

import com.unir.tiendacompulago.productservice.entity.Product;
import com.unir.tiendacompulago.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


//@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByCategory(Category category);
	public Product findByIdAndModelo(Long id, String modelo);

}
