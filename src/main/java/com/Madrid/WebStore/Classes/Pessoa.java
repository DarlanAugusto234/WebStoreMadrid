package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Pessoa {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 20, max = 100, message = "O nome deve ter 100 caracteres")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser uma data passada")
    private LocalDate dataNascimento;

    @NotBlank(message = "O endereço não pode estar em branco")
    @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres")
    private String endereco;

    @NotBlank(message = "O telefone não pode estar em branco")
    @Pattern(regexp = "^\\(?(\\d{2})\\)?[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$", message = "O telefone deve seguir o formato (99) 99999-9999 ou (99) 9999-9999")
    private String telefone;

    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "O CPF é inválido")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
}
