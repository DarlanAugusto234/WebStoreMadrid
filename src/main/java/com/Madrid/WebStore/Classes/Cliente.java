package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    @NotBlank
    private String emailCliente;

    @NotBlank
    private String senhaCliente;


    @ManyToMany
    // FALTANDO COMENTARIO O JOINTABLE
    @JoinTable(name = "Carrinho",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produto;


    public Cliente() {
    }

    public Cliente(String nome, LocalDate dataNascimento, String endereco, String telefone, String cpf, String emailCliente, String senhaCliente) {
        super(nome, dataNascimento, endereco, telefone, cpf);
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
