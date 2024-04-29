package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Cliente;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String nome;

    private String endereco;

    private String telefone;

    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    // Método auxiliar para converter um Cliente em um ClienteDTO
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEndereco(cliente.getEndereco());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setCpf(cliente.getCpf());
        return clienteDTO;
    }

}

