package com.apirest.Tienda.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallePedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @JoinColumn(name = "cliente_id", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @JoinColumn(name = "pedido_id", nullable = false)
  private Pedido pedido;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @JoinColumn(name = "producto_id", nullable = false)
  private Producto producto;

  @Column(name = "cantidad", nullable = false)
  private Integer amount;

  @Column(name = "precio_unidad", nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.00")
  private Double unitePrice;

  public double getPrecioTotal() {
    return producto.getPrice() * amount;
  }
}
