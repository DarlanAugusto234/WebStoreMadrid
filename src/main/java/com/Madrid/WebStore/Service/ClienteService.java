package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ClienteRepository;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    ProdutoRepositorio produtoRepositorio;

    public ClienteService(ClienteRepository clienteRepository, ProdutoRepositorio produtoRepositorio) {
        this.clienteRepository = clienteRepository;
        this.produtoRepositorio = produtoRepositorio;
    }

    // Cadastrar Cliente
    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    // Listar Clientes (testes)
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    // Deletar Cliente pelo Id
    public void deletarCliente(Integer id){
        clienteRepository.deleteById(id);
    }

    // Metódo para Buscar todos os Produtos Criados
    public List<Produto> listarProdutos(){
        return produtoRepositorio.findAll();
    }

    // Procurar Produto pela Categoria
    public List<Produto> procurarProdutoPorCategoria(String categoria) {
        return produtoRepositorio.findByCategoria(categoria);
    }

    // Adicionar um Produto ao Carrinho do Cliente
    public void adicionarProdutoAoCarrinho(Integer clienteId, Integer produtoId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(null);
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow(null);
        List<Produto> carrinho = cliente.getProduto();
        carrinho.add(produto);
        clienteRepository.save(cliente);
    }


}
