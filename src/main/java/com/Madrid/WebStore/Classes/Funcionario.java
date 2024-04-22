package com.Madrid.WebStore.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Funcionario extends Pessoa {

    private String emailFuncionario;

    private String senhaFuncionario;

    public Funcionario() {
    }

    // Construtor com todos os atributos
    public Funcionario(String nome, Date dataNascimento, String endereco, String telefone, String cpf, String emailFuncionario, String senhaFuncionario) {
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
