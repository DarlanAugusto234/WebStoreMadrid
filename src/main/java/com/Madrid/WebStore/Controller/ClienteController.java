package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Cadastro e Atualização do Cliente (Funcionando)
    @PostMapping("/cadastrarCliente")
    public void cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
    }

    // Buscar Cliente pelo Id (Metódo criado para ver o Cliente) (Funcionando)
    @GetMapping("/buscarCliente")
    public List<Cliente> buscarCliente() {
        return clienteService.listarCliente();
    }

    // Deletar Cliente ou Excluir Conta (Funcionando)
    @DeleteMapping("/deletarCliente/{id}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
    }

    // Buscar Produtos
    @GetMapping("/listarProdutos")
    public List<Produto> listarProdutos() {
        return clienteService.listarProdutos();
    }

    // Buscar Produto pela Categoria
    @GetMapping("/produtosPorCategoria/{categoria}")
    public List<Produto> procurarProdutosPorCategoria(@PathVariable String categoria) {
        return clienteService.procurarProdutoPorCategoria(categoria);
    }

    // Adicionando um Produto ao Carrinho do Cliente Pelo Id
    @PostMapping("/adicionarProdutoAoCarrinho/{clienteId}/{produtoId}")
    public void adicionarProdutoAoCarrinho(@PathVariable Integer clienteId, @PathVariable Integer produtoId) {
        clienteService.adicionarProdutoAoCarrinho(clienteId, produtoId);
    }

}
