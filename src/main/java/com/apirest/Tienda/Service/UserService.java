package com.apirest.Tienda.Service;

import java.util.List;

import com.apirest.Tienda.Entity.User;

public interface UserService {
  List<User> getAll() throws Exception;

  User getById(Integer id) throws Exception;

  User save(User user) throws Exception;

  User update(Integer id, User user) throws Exception;

  public boolean delete(Integer id) throws Exception;

}
