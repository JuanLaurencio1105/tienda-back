package com.apirest.Tienda.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.Tienda.Entity.Pedido;
import com.apirest.Tienda.Repository.PedidoRepository;

@Service
public class PedidoServiceIMPL implements PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Override
  public List<Pedido> getAll() throws Exception {
    try {
      return pedidoRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Pedido getById(Integer id) throws Exception {
    try {
      return pedidoRepository.findById(id).orElseThrow();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Pedido save(Pedido pedido) throws Exception {
    try {
      LocalDateTime fechaHoraActual = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      String fechaHoraPeru = fechaHoraActual.format(formatter);
      LocalDateTime fechaHoraActualPeru = LocalDateTime.parse(fechaHoraPeru, formatter);
      pedido.setDateOrder(fechaHoraActualPeru);
      return pedidoRepository.save(pedido);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Pedido update(Integer id, Pedido pedido) throws Exception {
    try {
      Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
      Pedido pedidotoUpdate = pedidoOptional.get();
      pedidotoUpdate = pedidoRepository.save(pedido);
      return pedidotoUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {
    try {
      if (pedidoRepository.existsById(id)) {
        pedidoRepository.deleteById(id);
      }
      return true;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
