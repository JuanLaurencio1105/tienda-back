package com.apirest.Tienda.Service;

import java.util.List;

import com.apirest.Tienda.Entity.DetallePedido;

public interface DetPedidoService {
  List<DetallePedido> getAll() throws Exception;

  DetallePedido getById(Integer id) throws Exception;

  DetallePedido save(DetallePedido detallePedido) throws Exception;

  DetallePedido update(Integer id, DetallePedido detallePedido) throws Exception;

  public boolean delete(Integer id) throws Exception;
}
