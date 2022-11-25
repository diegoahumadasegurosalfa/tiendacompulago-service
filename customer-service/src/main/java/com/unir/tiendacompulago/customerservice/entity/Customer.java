package com.unir.tiendacompulago.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_customer")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Customer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El numero de documento no puede ser vacio")
    @Size(min = 7, max = 15, message = "El tamaño del numero de documento debe ser entre 7 y 15")
    @Column(name = "number_id", unique = true, length = 15, nullable = false)
    private String numberId;

    @NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "El apellido no puede ser vacio")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "el correo no pede ser vacio")
    @Email(message = "no es una direccion de correo valida")
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "El telefono no puede ser vacío")
    private String phone;

    @NotEmpty(message = "La dirección no puede ser vacío")
    private String address;

    @NotNull(message = "La region no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    private String state;
}


