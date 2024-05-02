package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String nome;
    private String endereco;
    private String emailCliente;
    private String telefone;
    private String cpf;
    private List<ProdutoDTO> produto;

    public ClienteDTO() {
    }

    // FALTANDO COMENTARIO
    public ClienteDTO(String nome, String endereco, String emailCliente, String telefone, String cpf, List<ProdutoDTO> produto) {
        this.nome = nome;
        this.endereco = endereco;
        this.emailCliente = emailCliente;
        this.telefone = telefone;
        this.cpf = cpf;
        this.produto = produto;
    }

    // FALTANDO COMENTARIO
    public ClienteDTO(Cliente cliente) {
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        telefone = cliente.getTelefone();
        cpf = cliente.getCpf();
        emailCliente = cliente.getEmailCliente();
        // FALTANDO COMENTARIO NESSA LINHA TODA
        produto = cliente.getProduto().stream().map(ProdutoDTO::new).collect(Collectors.toList()); // Alteração para mapear para ProdutoDTO
    }

    public List<ProdutoDTO> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoDTO> produto) {
        this.produto = produto;
    }

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

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    // FALTANDO COMENTARIO
    public static List<ClienteDTO> convert(List<Cliente> cliente){
        return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

}

