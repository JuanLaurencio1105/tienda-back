package com.apirest.Tienda.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
// import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderID;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cliente_id")
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private Cliente cliente;

  @Column(name = "fecha_pedido", length = 40, nullable = false)
  private LocalDateTime dateOrder;

  @Column(name = "total_orden", nullable = false)
  private Double totalOrder;

  // @OneToMany(mappedBy = "pedido")
  // private List<DetallePedido> detallePedidos;
}
