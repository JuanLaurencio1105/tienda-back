package com.apirest.Tienda.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.Tienda.Entity.User;
import com.apirest.Tienda.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAll() throws Exception {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public User getById(Integer id) throws Exception {
    try {
      return userRepository.findById(id).orElseThrow();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public User save(User user) throws Exception {
    try {
      return userRepository.save(user);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public User update(Integer id, User user) throws Exception {
    try {
      Optional<User> userOptional = userRepository.findById(id);
      User userToUpdate = userOptional.get();
      userToUpdate = userRepository.save(user);
      return userToUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {
    try {
      if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return true;
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}