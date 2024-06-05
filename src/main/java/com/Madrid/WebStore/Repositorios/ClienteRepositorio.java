package com.Madrid.WebStore.Repositorios;

import com.Madrid.WebStore.Classes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
