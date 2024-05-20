package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

<<<<<<< HEAD
    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
=======
    List<ProdutoDTO> findByNomeProduto(String nomeProduto);
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30

    // Query das Pesquisa da Home
    List<Produto> findByCategoriaNomeCategoriaContainingIgnoreCase(String query);

    List<Produto> findByCorContainingIgnoreCase(String query);

    List<Produto> findByTamanhoContainingIgnoreCase(String query);

    List<Produto> findByTecidoContainingIgnoreCase(String query);

    List<Produto> findByMarcaContainingIgnoreCase(String query);

    // COMENTAR AQUI
    List<Produto> findAllByOrderByValorDesc();

    List<Produto> findAllByOrderByValorAsc();

    // COMENTAR AQUI
    List<Produto> findByDestaqueTrue();
}
