package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ClienteDTO;
import com.Madrid.WebStore.Service.ClienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClienteController {

    ClienteService clienteService;

    ModelMapper modelMapper;

    public ClienteController(ClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
    }

    // Metodo para Cadastrar ou Atualizar Cliente
    @PostMapping("/cadastrarCliente")
    public void cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
    }

    // Listar Todos os ClientesDTO
    @GetMapping("/listarTodosOsClientes")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    // Procurar Pelo Id do Cliente
    @GetMapping("/procurarClientePeloId/{clienteId}")
    public Cliente getClienteById(@PathVariable Integer clienteId) {
        return clienteService.procurarClientePorId(clienteId);
    }

    // Procurar Cliente pelo Nome
    @GetMapping("/procurarClientePeloNome/{nome}")
    public List<Cliente> getClienteByNome(@PathVariable String nome) {
        return clienteService.procurarClientePorNome(nome);
    }

    // Deletar Cliente ou Excluir Conta
    @DeleteMapping("/deletarCliente/{id}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
    }


    // Adicionando um Produto ao Carrinho do Cliente Pelo Id
    @PostMapping("/adicionarProdutoAoCarrinho/{clienteId}/{produtoId}")
    public void adicionarProdutoAoCarrinho(@PathVariable Integer clienteId, @PathVariable Integer produtoId) {
        clienteService.adicionarProdutoAoCarrinho(clienteId, produtoId);
    }

}
