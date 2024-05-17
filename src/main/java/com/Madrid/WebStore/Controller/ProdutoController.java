package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
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
    public void cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoService.cadastrarProduto(produtoDTO);
    }

    // Deletar Produto pelo Id
    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
    }

    // Listar Todos os Produtos
    @GetMapping("/listarTodosProdutos")
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarTodos();
    }

    // Procurar Produto pelo Nome
    @GetMapping("/procurarProdutoPeloNome/{nome}")
    public List<ProdutoDTO> procurarProdutoPorNome(@PathVariable String nome) {
        return produtoService.procurarProdutoPorNome(nome);
    }

}
