package com.apirest.Tienda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.Tienda.Entity.Cliente;
import com.apirest.Tienda.Entity.DetallePedido;
import com.apirest.Tienda.Entity.Producto;
import com.apirest.Tienda.Repository.ClienteRepository;
import com.apirest.Tienda.Repository.ProductoRepository;

@Service
public class ClienteServiceIMPL implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ProductoRepository productoRepository;

  @Override
  public List<Cliente> getAll() throws Exception {
    try {
      return clienteRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Cliente getById(Integer id) throws Exception {
    try {
      return clienteRepository.findById(id).orElseThrow();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Cliente save(Cliente cliente) throws Exception {
    try {
      return clienteRepository.save(cliente);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Cliente update(Integer id, Cliente cliente) throws Exception {
    try {
      Optional<Cliente> clienteOptional = clienteRepository.findById(id);
      Cliente clienteToUpdate = clienteOptional.get();
      clienteToUpdate = clienteRepository.save(cliente);
      return clienteToUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {
    try {
      if (clienteRepository.existsById(id)) {
        clienteRepository.deleteById(id);
        return true;
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public void agregarAlCarrito(Integer clienteId, Integer productoId, int cantidad) throws Exception {
    try {
      Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
      if (!clienteOptional.isPresent()) {
        throw new Exception("Cliente no encontrado con ID:" + clienteId);
      }
      Cliente cliente = clienteOptional.get();

      Optional<Producto> productoOptional = productoRepository.findById(productoId);
      if (!productoOptional.isPresent()) {
        throw new Exception("Producto no encontrado con ID:" + productoId);
      }
      Producto producto = productoOptional.get();
      if (producto.getStock() < cantidad) {
        throw new Exception("La cantidad solicitada es mayor al inventario");
      }
      cliente.addProductCarrito(producto, cantidad);
      producto.setStock(producto.getStock() - cantidad);
      productoRepository.save(producto);
      clienteRepository.save(cliente);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public double calcularTotalCarrito(Integer id) throws Exception {
    try {
      Optional<Cliente> clienteOptional = clienteRepository.findById(id);
      if (!clienteOptional.isPresent()) {
        throw new Exception("Cliente no encontrado con ID:" + id);
      }
      Cliente cliente = clienteOptional.get();
      return cliente.calcularTotalCarrito();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public void limpiarCarrito(Integer id) throws Exception {
    try {
      Optional<Cliente> clienteOptional = clienteRepository.findById(id);
      if (!clienteOptional.isPresent()) {
        throw new Exception("Cliente no encontrado con ID:" + id);
      }
      Cliente cliente = clienteOptional.get();

      List<DetallePedido> carrito = cliente.getCarrito();

      if (carrito == null || carrito.isEmpty()) {
        throw new Exception("El carrito del cliente esta vacio");
      }

      carrito.clear();
      clienteRepository.save(cliente);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
