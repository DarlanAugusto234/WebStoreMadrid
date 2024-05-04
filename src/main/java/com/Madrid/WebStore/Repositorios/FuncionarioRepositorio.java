package com.Madrid.WebStore.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Madrid.WebStore.Classes.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

}
