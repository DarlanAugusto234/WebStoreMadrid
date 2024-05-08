package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Funcionario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public Funcionario converterParaFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(this.nome);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setEndereco(this.endereco);
        funcionario.setTelefone(this.telefone);
        funcionario.setCpf(this.cpf);
        funcionario.setEmailFuncionario(this.emailFuncionario);
        funcionario.setSenhaFuncionario(this.senhaFuncionario);
        return funcionario;
    }

    public static FuncionarioDTO converterDeFuncionario(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setDataNascimento(funcionario.getDataNascimento());
        funcionarioDTO.setEndereco(funcionario.getEndereco());
        funcionarioDTO.setTelefone(funcionario.getTelefone());
        funcionarioDTO.setCpf(funcionario.getCpf());
        funcionarioDTO.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioDTO.setSenhaFuncionario(funcionario.getSenhaFuncionario());
        return funcionarioDTO;
    }

    // Método para converter lista de Funcionario para lista de FuncionarioDTO
    public static List<FuncionarioDTO> converterListaDeFuncionarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(funcionario -> new FuncionarioDTO(
                        funcionario.getNome(),
                        funcionario.getDataNascimento(),
                        funcionario.getEndereco(),
                        funcionario.getTelefone(),
                        funcionario.getCpf(),
                        funcionario.getEmailFuncionario(),
                        funcionario.getSenhaFuncionario()
                ))
                .collect(Collectors.toList());
    }

}
