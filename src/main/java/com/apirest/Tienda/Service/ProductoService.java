package com.apirest.Tienda.Service;

import java.util.List;
import com.apirest.Tienda.Entity.Producto;

public interface ProductoService {
  List<Producto> getAll() throws Exception;

  Producto getById(Integer id) throws Exception;

  Producto save(Producto producto) throws Exception;

  Producto update(Integer id, Producto producto) throws Exception;

  public boolean delete(Integer id) throws Exception;
}
