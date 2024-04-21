package com.Madrid.WebStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.Repositorios.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastroAdministrador(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void adicionarProduto(Funcionario funcionario, Produto produto) {
        funcionario.getProdutos().add(produto);
    }

    public void removerProduto(Funcionario funcionario, Produto produto) {
        funcionario.getProdutos().remove(produto);
    }
}

