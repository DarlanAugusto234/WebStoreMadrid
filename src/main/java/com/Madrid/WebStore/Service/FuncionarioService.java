package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
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

    public void cadastrarProduto(Produto produto) {
        produtoRepositorio.save(produto);
    }

    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

    public void ativarProduto(Integer produtoId) {
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow(null);
        produto.ativar();
    }

    public void inativarProduto(Integer produtoId) {
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow(null);
        produto.desativar();
    }

}

