package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Classes.Produto;
<<<<<<< HEAD
import com.Madrid.WebStore.DTO.ProdutoDTO;
=======
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
import com.Madrid.WebStore.Service.CategoriaService;
import com.Madrid.WebStore.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    ProdutoService produtoService;

    CategoriaService categoriaService;

    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    // Cadastrar Produto
<<<<<<< HEAD
    @PostMapping("/cadastrarProduto")
    public void cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.cadastrarProduto(produtoDTO);
=======
    @PostMapping("/cadastrarProduto/{idCategoria}")
    public void cadastrarProduto(@RequestBody Produto produto, @PathVariable Integer idCategoria) {
        produtoService.cadastrarProduto(produto, idCategoria);
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
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
