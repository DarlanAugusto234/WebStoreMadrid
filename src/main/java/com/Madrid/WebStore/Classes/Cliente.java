package com.Madrid.WebStore.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    @NotBlank(message = "O Email do Cliente não pode estar em branco")
    // COMENTAR AQUI
    @Email(message = "O Email do Cliente deve ser válido")
    private String emailCliente;

    @NotBlank(message = "A Senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "A Senha deve ter entre 8 e 20 caracteres")
    // COMENTAR AQUI
    @Pattern(
            // COMENTAR AQUI
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d{4,}).{8,20}$",
            message = "Sua Senha deve conter pelo menos uma letra maiúscula, uma letra minúscula e quatro números")
    private String senhaCliente;

    @ManyToMany
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
