package com.apirest.Tienda.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Producto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre_producto", length = 50, nullable = false)
  private String nameProduct;

  @Column(name = "descripcion", length = 100, nullable = false)
  private String description;

  @Column(name = "precio", length = 10, nullable = false)
  private double price;

  @Column(name = "stock", length = 10, nullable = false)
  private Integer stock;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoria_id")
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private Categoria categoria;
}