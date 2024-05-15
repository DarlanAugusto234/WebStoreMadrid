package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

    List<ProdutoDTO> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

}
