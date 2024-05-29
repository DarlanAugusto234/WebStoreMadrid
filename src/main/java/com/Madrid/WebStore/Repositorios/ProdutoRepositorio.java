package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

    // Query das Pesquisa da Home
    List<Produto> findByCategoriaNomeCategoriaContainingIgnoreCase(String query);

    List<Produto> findByCorContainingIgnoreCase(String query);

    List<Produto> findByTamanhoContainingIgnoreCase(String query);

    List<Produto> findByTecidoContainingIgnoreCase(String query);

    List<Produto> findByMarcaContainingIgnoreCase(String query);

    // COMENTAR AQUI
    List<Produto> findAllByOrderByPrecoDesc();

    List<Produto> findAllByOrderByPrecoAsc();

    // COMENTAR AQUI
    List<Produto> findByDestaqueTrue();
}
