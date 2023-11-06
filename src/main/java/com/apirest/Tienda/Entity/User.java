package com.apirest.Tienda.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre_usuario", length = 20, nullable = false, unique = true)
  private String userName;

  @Column(name = "email", length = 50, nullable = false, unique = true)
  private String email;

  @Column(name = "contraseña", length = 10, nullable = false)
  private String password;
}
