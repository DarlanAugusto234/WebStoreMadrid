package com.Madrid.WebStore.Classes;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Funcionario extends Pessoa {

    @NotBlank(message = "O Email do Funcionario não pode estar em branco")
    @Email(message = "O Email do Funcionario deve ser válido")
    private String emailFuncionario;

    @NotBlank(message = "A Senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "A Senha deve ter entre 8 e 20 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d{4,}).{8,20}$",
            message = "Sua Senha deve conter pelo menos uma letra maiúscula, uma letra minúscula e quatro números"
    )
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
