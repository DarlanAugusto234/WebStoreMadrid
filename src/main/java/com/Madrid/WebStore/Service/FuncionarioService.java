package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.Repositorios.FuncionarioRepository;

@Service
public class FuncionarioService {

    FuncionarioRepository funcionarioRepository;

    ProdutoRepositorio produtoRepositorio;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, ProdutoRepositorio produtoRepositorio) {
        this.funcionarioRepository = funcionarioRepository;
        this.produtoRepositorio = produtoRepositorio;
    }

    public void cadastroAdministrador(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void adicionarProduto() {
    }

    public void removerProduto() {
    }

    public void ativarProduto(Produto produto) {
        produto.ativar();
    }

    public void desativarProduto(Produto produto) {
        produto.desativar();
    }

}

