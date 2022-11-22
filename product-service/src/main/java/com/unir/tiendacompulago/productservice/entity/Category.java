package com.unir.tiendacompulago.productservice.entity;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name="tbl_categories")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
}