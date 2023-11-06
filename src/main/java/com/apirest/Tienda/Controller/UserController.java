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
import org.springframework.web.bind.annotation.RestController;

import com.apirest.Tienda.Entity.User;
import com.apirest.Tienda.Repository.UserRepository;
import com.apirest.Tienda.Service.UserService;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api/auth")
public class UserController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) throws Exception {
    String userName = credentials.get("userName");
    String password = credentials.get("password");

    User user = userRepository.findByUserName(userName);
    if (user != null && user.getPassword().equals(password)) {
      return ResponseEntity.status(HttpStatus.OK).body(userName);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("EL USUARIO NO ESTA AUTORIZADO");
    }
  }

  @GetMapping
  public ResponseEntity<?> getAll() throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody User user) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, user));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

}
