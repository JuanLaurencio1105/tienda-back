package com.apirest.Tienda.Service;

import java.util.List;

import com.apirest.Tienda.Entity.Cliente;

public interface ClienteService {
  List<Cliente> getAll() throws Exception;

  Cliente getById(Integer id) throws Exception;

  Cliente save(Cliente cliente) throws Exception;

  Cliente update(Integer id, Cliente cliente) throws Exception;

  public boolean delete(Integer id) throws Exception;

  void agregarAlCarrito(Integer clienteId, Integer productoId, int cantidad) throws Exception;

  double calcularTotalCarrito(Integer id) throws Exception;

  void limpiarCarrito(Integer id) throws Exception;
}
