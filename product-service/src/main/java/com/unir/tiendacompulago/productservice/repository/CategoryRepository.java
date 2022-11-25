package com.unir.tiendacompulago.productservice.repository;

import com.unir.tiendacompulago.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByname(String name);
}
