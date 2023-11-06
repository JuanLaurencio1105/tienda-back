package com.apirest.Tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.Tienda.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
