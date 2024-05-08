package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    ClienteRepositorio clienteRepositorio;

    ProdutoRepositorio produtoRepositorio;

    public ClienteService(ClienteRepositorio clienteRepositorio, ProdutoRepositorio produtoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    // Cadastrar e Atualizar Clientes
    public void cadastrarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    // Listar Clientes
    public List<Cliente> listarCliente(){
        return clienteRepositorio.findAll();
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
        return clienteRepositorio.findByNome(nome);
    }

    // Adicionar um Produto ao Carrinho do Cliente
    public void adicionarProdutoAoCarrinho(Integer clienteId, Integer produtoId) {
        Cliente cliente = clienteRepositorio.findById(clienteId).get();
        Produto produto = produtoRepositorio.findById(produtoId).get();

        // Verifica se o produto está disponível para venda antes de adicionar ao carrinho
        if (produto.disponivelParaVenda()) {
            List<Produto> carrinho = cliente.getProduto();
            carrinho.add(produto);
            clienteRepositorio.save(cliente);
        }
    }

}
