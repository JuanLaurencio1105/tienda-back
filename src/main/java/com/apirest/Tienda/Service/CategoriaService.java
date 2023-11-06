package com.apirest.Tienda.Service;

import java.util.List;

import com.apirest.Tienda.Entity.Categoria;

public interface CategoriaService {
  List <Categoria> getAll() throws Exception;
  Categoria getById(Integer id) throws Exception;
  Categoria save(Categoria categoria) throws Exception;
  Categoria update(Integer id, Categoria categoria) throws Exception;
  public boolean delete(Integer id) throws Exception;
}
