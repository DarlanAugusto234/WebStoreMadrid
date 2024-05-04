package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

    List<Produto> findByCategoria(String categoria);

    List<Produto> findByNomeProduto(String nomeProduto);

}
