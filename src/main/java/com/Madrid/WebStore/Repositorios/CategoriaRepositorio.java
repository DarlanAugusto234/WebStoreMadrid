package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    List<Categoria> findByNomeCategoriaContainingIgnoreCase(String nomeCategoria);

}
