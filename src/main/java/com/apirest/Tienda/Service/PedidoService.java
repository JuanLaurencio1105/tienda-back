package com.apirest.Tienda.Service;

import java.util.List;

import com.apirest.Tienda.Entity.Pedido;

public interface PedidoService {
  List<Pedido> getAll() throws Exception;
  Pedido getById(Integer id) throws Exception;
  Pedido save(Pedido pedido) throws Exception;
  Pedido update(Integer id, Pedido pedido) throws Exception;
  public boolean delete(Integer id) throws Exception;
}
