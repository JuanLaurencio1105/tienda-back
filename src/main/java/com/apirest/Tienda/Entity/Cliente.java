package com.apirest.Tienda.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "numero_identificacion", length = 13, nullable = false, unique = true)
  private String numberIdentification;

  @Column(name = "nombres", length = 50, nullable = false)
  private String names;

  @Column(name = "apellidos", length = 50, nullable = false)
  private String lastNames;

  @Column(name = "numero_telefono", length = 50, nullable = false)
  private String phoneNumber;

  @Column(name = "email", length = 100, nullable = false, unique = true)
  private String email;

  @Column(name = "direccion", length = 150, nullable = false)
  private String address;

  @Column(name = "contraseña", length = 10, nullable = false)
  private String password;

  @OneToMany(mappedBy = "cliente")
  private List<DetallePedido> carrito;

  public void addProductCarrito(Producto producto, int cantidad) {
    if (carrito == null) {
      carrito = new ArrayList<>();
    }

    DetallePedido detallePedido = new DetallePedido();
    detallePedido.setProducto(producto);
    detallePedido.setAmount(cantidad);
    detallePedido.setCliente(this);
    carrito.add(detallePedido);
  }

  public double calcularTotalCarrito() {
    double total = 0.0;
    if (carrito != null) {
      for (DetallePedido detallePedido : carrito) {
        total += detallePedido.getPrecioTotal();
      }
    }
    return total;
  }

}
