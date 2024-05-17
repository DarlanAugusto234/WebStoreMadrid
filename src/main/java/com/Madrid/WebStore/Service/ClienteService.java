package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ClienteDTO;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    ClienteRepositorio clienteRepositorio;

    ProdutoRepositorio produtoRepositorio;

    ModelMapper modelMapper;

    public ClienteService(ClienteRepositorio clienteRepositorio, ProdutoRepositorio produtoRepositorio, ModelMapper modelMapper) {
        this.clienteRepositorio = clienteRepositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.modelMapper = modelMapper;
    }

    // Cadastrar e Atualizar Clientes
    public void cadastrarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    // Listar Clientes
    public List<ClienteDTO> buscarClientes() {
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        List<Cliente> clientes = clienteRepositorio.findAll();

        for (Cliente cliente : clientes) {
            clienteDTOs.add(modelMapper.map(cliente, ClienteDTO.class));
        }

        return clienteDTOs;
    }

    // Deletar Cliente pelo Id
    public void deletarCliente(Integer id){
        clienteRepositorio.deleteById(id);
    }

    // Procurar Cliente por ID
    public Cliente procurarClientePorId(Integer clienteId) {
        return clienteRepositorio.findById(clienteId).orElseThrow();
    }

    // Procurar Cliente por Nome
    public List<Cliente> procurarClientePorNome(String nome) {
        return clienteRepositorio.findByNomeContainingIgnoreCase(nome);
    }

    // Adicionar um Produto ao Carrinho do Cliente
    public void adicionarProdutoAoCarrinho(Integer clienteId, Integer produtoId) {
        Cliente cliente = clienteRepositorio.findById(clienteId).orElseThrow();
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow();

        // Verifica se o produto está disponível para venda antes de adicionar ao carrinho
        if (produto.disponivelParaVenda() > 0) {
            List<Produto> carrinho = cliente.getProduto();
            carrinho.add(produto);
            clienteRepositorio.save(cliente);
        }
    }

}
