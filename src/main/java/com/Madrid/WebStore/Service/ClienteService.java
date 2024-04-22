package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ClienteRepository;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

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

    // Buscar Pelo Id do Cliente
    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Deletar Cliente pelo Id
    public void deletarCliente(Integer id){
        clienteRepository.deleteById(id);
    }

    // Metódo para Mostrar todos os Produtos Criados
    public List<Produto> listarProdutos(){
        return produtoRepositorio.findAll();
    }

    // Procurar Produto pela Categoria
    public List<Produto> procurarProdutoPorCategoria(String categoria) {
        return produtoRepositorio.findByCategoria(categoria);
    }

    // Adicionar um Produto ao Carrinho do Cliente
    public void adicionarProdutoAoCarrinho(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(null);
        Produto produto = produtoRepositorio.findById(id).orElseThrow(null);
        List<Produto> carrinho = cliente.getProduto();
        carrinho.add(produto);
        clienteRepository.save(cliente);
    }

}
