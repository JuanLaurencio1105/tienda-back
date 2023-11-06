package com.apirest.Tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.Tienda.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  Cliente findByEmail(String email);
}
