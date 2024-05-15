package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String nome;
    private String endereco;
    private String emailCliente;
    private String telefone;
    private String cpf;
    private List<Produto> produto;
    private List<Integer> produtosNoCarrinho;
    private ModelMapper modelMapper = new ModelMapper();

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String endereco, String emailCliente, String telefone,
                      String cpf, List<Produto> produto) {
        this.nome = nome;
        this.endereco = endereco;
        this.emailCliente = emailCliente;
        this.telefone = telefone;
        this.cpf = cpf;
        this.produto = produto;
    }

    // Construtor responsável por criar um ClienteDTO a partir de um objeto Cliente
    public ClienteDTO(Cliente cliente) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        // Mapeia os atributos simples do cliente para o DTO
        modelMapper.map(cliente, this);

        // Mapeia a lista de produtos do cliente para uma lista de ProdutoDTOs
        produto = modelMapper.map(cliente.getProduto(), new TypeToken<List<ProdutoDTO>>() {}.getType());

        // Mapeia a lista de IDs de produtos no carrinho do cliente
        produtosNoCarrinho = new ArrayList<>();
        List<Produto> produtos = cliente.getProduto();
        for (Produto produto : produtos) {
            produtosNoCarrinho.add(produto.getId());
        }
    }

    public List<Integer> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void setProdutosNoCarrinho(List<Integer> produtosNoCarrinho) {
        this.produtosNoCarrinho = produtosNoCarrinho;
    }

    // Getters e Setters
    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}