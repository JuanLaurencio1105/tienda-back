package com.apirest.Tienda.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoriaID;

  @Column(name = "nombre_categoria", length = 50, nullable = false)
  private String nameCategory;
}
