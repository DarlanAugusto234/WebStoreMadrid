package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Funcionario;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class FuncionarioDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String cpf;
    private String emailFuncionario;
    private String senhaFuncionario;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(String nome, LocalDate dataNascimento, String endereco, String telefone, String cpf, String emailFuncionario, String senhaFuncionario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
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

    // Utilizando ModelMapper para converter de FuncionarioDTO para Funcionario
    public static Funcionario fromEmployeeDTOtoEmployee(FuncionarioDTO funcionarioDTO, ModelMapper modelMapper) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }

    // Utilizando ModelMapper para converter de Funcionario para FuncionarioDTO
    public static FuncionarioDTO fromEmployeeToEmployeeDTO(Funcionario funcionario, ModelMapper modelMapper) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

}
