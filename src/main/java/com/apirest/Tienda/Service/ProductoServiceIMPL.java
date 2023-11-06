package com.apirest.Tienda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.Tienda.Entity.Producto;
import com.apirest.Tienda.Repository.ProductoRepository;

@Service
public class ProductoServiceIMPL implements ProductoService {

  @Autowired
  private ProductoRepository productoRepository;

  @Override
  public List<Producto> getAll() throws Exception {
    try {
      return productoRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Producto getById(Integer id) throws Exception {
    try {
      return productoRepository.findById(id).orElseThrow();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Producto save(Producto producto) throws Exception {
    try {
      return productoRepository.save(producto);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Producto update(Integer id, Producto producto) throws Exception {
    try {
      Optional<Producto> productoOptional = productoRepository.findById(id);
      Producto productoToUpdate = productoOptional.get();
      productoToUpdate = productoRepository.save(producto);
      return productoToUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {

    if (productoRepository.existsById(id)) {
      productoRepository.deleteById(id);
    }

    return true;
  }

}
