package com.apirest.Tienda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.Tienda.Entity.DetallePedido;
import com.apirest.Tienda.Repository.DetPedRepository;

@Service
public class DetPedidoServiceIMPL implements DetPedidoService {

  @Autowired
  private DetPedRepository detPedRepository;

  @Override
  public List<DetallePedido> getAll() throws Exception {
    try {
      return detPedRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public DetallePedido getById(Integer id) throws Exception {
    try {
      return detPedRepository.findById(id).orElseThrow();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public DetallePedido save(DetallePedido detallePedido) throws Exception {
    try {
      return detPedRepository.save(detallePedido);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public DetallePedido update(Integer id, DetallePedido detallePedido) throws Exception {
    try {
      Optional<DetallePedido> detalleOptional = detPedRepository.findById(id);
      DetallePedido detallePedidoUpdate = detalleOptional.get();
      detallePedidoUpdate = detPedRepository.save(detallePedido);
      return detallePedidoUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {
    try {
      if (detPedRepository.existsById(id)) {
        detPedRepository.deleteById(id);
      } else {
        throw new Exception();
      }
      return true;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
