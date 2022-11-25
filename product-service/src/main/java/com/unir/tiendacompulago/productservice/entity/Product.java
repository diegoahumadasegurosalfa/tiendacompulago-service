package com.unir.tiendacompulago.productservice.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_products")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El modelo no debe ser vacío")
	private String modelo;

	@NotEmpty(message = "La marca no debe ser vacía")
	private String marca;

	private String procesador;
	private String memoria;
	private String hhdd;
	private String ssd;
	private String pantalla;

	@Positive(message = "El stock debe ser mayor que cero")
	private Double stock;
	private Double precio;
	private String status;

	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@NotNull(message = "La categoria no puede ser vacia")
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Category category;

}

