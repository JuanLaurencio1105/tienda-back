package com.apirest.Tienda.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.apirest.Tienda.Entity.Categoria;
import com.apirest.Tienda.Service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = { "*" })
public class CategoriaController {

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping
  public ResponseEntity<?> getAll() throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Categoria categoria) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Categoria categoria) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(id, categoria));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(categoriaService.delete(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
