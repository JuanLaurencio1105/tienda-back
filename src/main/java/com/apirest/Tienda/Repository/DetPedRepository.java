package com.apirest.Tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.Tienda.Entity.DetallePedido;

@Repository
public interface DetPedRepository extends JpaRepository<DetallePedido, Integer> {

}
