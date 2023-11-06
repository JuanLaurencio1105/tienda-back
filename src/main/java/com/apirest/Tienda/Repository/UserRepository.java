package com.apirest.Tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.Tienda.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUserName(String userName);
}
