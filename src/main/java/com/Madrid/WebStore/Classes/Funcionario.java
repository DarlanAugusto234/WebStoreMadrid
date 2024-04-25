package com.Madrid.WebStore.Classes;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Funcionario extends Pessoa {

    @NotBlank
    private String emailFuncionario;

    @NotBlank
    private String senhaFuncionario;

    public Funcionario() {
    }

    // Construtor com todos os atributos
    public Funcionario(String nome, LocalDate dataNascimento, String endereco, String telefone, String cpf, String emailFuncionario, String senhaFuncionario) {
        super(nome, dataNascimento, endereco, telefone, cpf);
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

}
