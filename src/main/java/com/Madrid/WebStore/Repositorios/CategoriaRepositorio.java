package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    List<Categoria> findByNomeCategoria(String nomeCategoria);

<<<<<<< HEAD
=======
    Optional<Categoria> findById(Integer idCategoria);

>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
}
