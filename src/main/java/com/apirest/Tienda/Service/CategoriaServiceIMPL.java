package com.apirest.Tienda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.Tienda.Entity.Categoria;
import com.apirest.Tienda.Repository.CategoriaRepository;

@Service
public class CategoriaServiceIMPL implements CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Override
  public List<Categoria> getAll() throws Exception {
    try {
      return categoriaRepository.findAll();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Categoria getById(Integer id) throws Exception {
    try {
      return categoriaRepository.findById(id).orElseThrow();

    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Categoria save(Categoria categoria) throws Exception {
    try {
      return categoriaRepository.save(categoria);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public Categoria update(Integer id, Categoria categoria) throws Exception {
    try {
      Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
      Categoria categoriaToUpdate = categoriaOptional.get();
      categoriaToUpdate = categoriaRepository.save(categoria);
      return categoriaToUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(Integer id) throws Exception {
    try {
      if(categoriaRepository.existsById(id)) {
        categoriaRepository.deleteById(id);
        return true;
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
