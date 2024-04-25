package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    @NotBlank
    private String emailCliente;

    @NotBlank
    private String senhaCliente;

    @ManyToMany
    @JoinTable(name = "Carrinho",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produto;


    public Cliente() {
    }

    public Cliente(String nome, LocalDate dataNascimento, String endereco, String telefone, String cpf, String email_cliente, String senha_cliente) {
        super(nome, dataNascimento, endereco, telefone, cpf);
        this.emailCliente = email_cliente;
        this.senhaCliente = senha_cliente;
    }

    public String getEmail_cliente() {
        return emailCliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.emailCliente = email_cliente;
    }

    public String getSenha_cliente() {
        return senhaCliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senhaCliente = senha_cliente;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
