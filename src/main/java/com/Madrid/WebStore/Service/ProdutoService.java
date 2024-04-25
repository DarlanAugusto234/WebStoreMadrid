package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepositorio produtoRepositorio;

    public ProdutoService(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    // Cadastrar Produto
    public void cadastrarProduto(Produto produto) {
        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<Produto> listarProdutos(){
        return produtoRepositorio.findAll();
    }

    // Listar Produtos pela Categoria
    public List<Produto> procurarProdutoPorCategoria(String categoria) {
        return produtoRepositorio.findByCategoria(categoria);
    }

    // Procurar Produto pelo nome
    public List<Produto> procurarProdutoPorNome(String nome) {
        return produtoRepositorio.findByNome(nome);
    }

    // Deletar Produto Pelo Id
    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

    // Ativar Produto
    public void ativarProduto(Integer produtoId) {
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow();
        produto.ativar(); // Chama o método ativar da classe Produto
        produtoRepositorio.save(produto);
    }

    // Inativar Produto
    public void inativarProduto(Integer produtoId) {
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow();
        produto.desativar(); // Chama o método desativar da classe Produto
        produtoRepositorio.save(produto);
    }

}
