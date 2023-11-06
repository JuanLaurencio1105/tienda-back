package com.apirest.Tienda.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.Tienda.Entity.Cliente;
import com.apirest.Tienda.Repository.ClienteRepository;
import com.apirest.Tienda.Service.ClienteService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = { "*" })
public class ClienteController {

  @Autowired
  private ClienteService clienteService;
  @Autowired
  private ClienteRepository clienteRepository;
  private final String ERROR = "{\"error\": \"Por favor intente más tarde.\"}";


  @PostMapping("/auth/login")
  public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) throws Exception {

    String name = credentials.get("names");
    String email = credentials.get("email");
    String password = credentials.get("password");

    // Cliente client = clienteRepository.findByUserName(email);
    Cliente client = clienteRepository.findByEmail(email);
    if (client != null && client.getPassword().equals(password)) {
      return ResponseEntity.status(HttpStatus.OK).body(name);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("EL USUARIO NO ESTA AUTORIZADO");
    }
  }

  @GetMapping
  public ResponseEntity<?> getAll() throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clienteService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Cliente cliente) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, cliente));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clienteService.delete(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR);
    }
  }

  @PostMapping("/{id}/carrito/agregar")
  public ResponseEntity<?> agregarAlCarrito(@PathVariable Integer id, @RequestParam Integer productoID,
      @RequestParam int cantidad) throws Exception {
    try {
      clienteService.agregarAlCarrito(id, productoID, cantidad);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/{id}/carrito/total")
  public ResponseEntity<?> calcularTotalCarrito(@PathVariable Integer id) throws Exception {
    try {
      double total = clienteService.calcularTotalCarrito(id);
      return ResponseEntity.status(HttpStatus.OK).body(total);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping("{id}/carrito/limpiar")
  public ResponseEntity<?> limpiarCarrito(@PathVariable Integer id) throws Exception {
    try {
      clienteService.limpiarCarrito(id);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
