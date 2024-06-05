package com.Madrid.WebStore.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClienteDTO {
    @JsonIgnore
    private Integer id;
    private String nome;
    private String endereco;
    private String emailCliente;
    private String telefone;
    private String cpf;
    @JsonIgnore
    private List<ProdutoDTO> produto;

    public ClienteDTO() {}

    public ClienteDTO(String nome, String endereco, String emailCliente, String telefone, String cpf, List<ProdutoDTO> produto) {
        this.nome = nome;
        this.endereco = endereco;
        this.emailCliente = emailCliente;
        this.telefone = telefone;
        this.cpf = cpf;
        this.produto = produto;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
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

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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

    public List<ProdutoDTO> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoDTO> produto) {
        this.produto = produto;
    }
}
