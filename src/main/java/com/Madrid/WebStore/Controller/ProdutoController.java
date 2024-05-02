package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Cadastrar Produto
    @PostMapping("/cadastrarProduto")
    public void cadastroProduto(@Valid @RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
    }

    // Deletar Produto pelo Id
    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
    }

    // Listar Todos os Produtos
    @GetMapping("/listarProdutos")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Procurar pela Categoria
    @GetMapping("/procurarProdutoPelaCategoria/{categoria}")
    public List<Produto> getProdutoByCategoria(@PathVariable String categoria) {
        return produtoService.procurarProdutoPorCategoria(categoria);
    }

    // Procurar Produto pelo Nome
    @GetMapping("/procurarProduto/{nome}")
    public List<Produto> getProdutoByNome(@PathVariable String nome) {
        return produtoService.procurarProdutoPorNome(nome);
    }

    // Ativar Produto
    @PutMapping("/ativarProduto/{id}")
    public void ativarProduto(@PathVariable Integer id) {
        produtoService.ativarProduto(id);
    }

    // Inativar Produto
    @PutMapping("/inativarProduto/{id}")
    public void inativarProduto(@PathVariable Integer id) {
        produtoService.inativarProduto(id);
    }

}
