package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuncionarioController {

    FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Cadastrar Funcionario
    @PostMapping("/cadastrarFuncionario")
    public void cadastroFuncionario(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.cadastroAdministrador(funcionario);
    }

    // Cadastrar Produto
    @PostMapping("/cadastrarProduto")
    public void cadastroProduto(@Valid @RequestBody Produto produto) {
        funcionarioService.cadastrarProduto(produto);
    }

    // Deletar Produto pelo Id
    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        funcionarioService.deletarProduto(id);
    }

    //
    @PutMapping("/ativar/{id}")
    public void ativarProduto(@PathVariable Integer id) {
        funcionarioService.ativarProduto(id);
    }

    //
    @PutMapping("/inativar/{id}")
    public void inativarProduto(@PathVariable Integer id) {
        funcionarioService.inativarProduto(id);
    }

}
