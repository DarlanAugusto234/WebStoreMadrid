package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    private String email_cliente;

    private String senha_cliente;

    @OneToMany(mappedBy = "cliente")
    private List<Produto> produto;

    public Cliente() {
    }

    public Cliente(String nome, Date dataNascimento, String endereco, String telefone, String cpf, String email_cliente, String senha_cliente) {
        super(nome, dataNascimento, endereco, telefone, cpf);
        this.email_cliente = email_cliente;
        this.senha_cliente = senha_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
