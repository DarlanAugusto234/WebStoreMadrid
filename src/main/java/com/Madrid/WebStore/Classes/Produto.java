package com.Madrid.WebStore.Classes;

import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String cor;

    @NotBlank
    private String tamanho;

    @NotBlank
    private String marca;

    @NotBlank
    private String tipo;

    @NotNull
    private Double valor;

    private boolean estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Cliente> clientes;

    private static ModelMapper modelMapper = new ModelMapper();

    public Produto() {
    }

    // Utilizando construtor para inicializar todos os atributos da classe
    public Produto(Integer id, String nomeProduto, String cor, String tamanho, String marca,
                   String tipo, Double valor, boolean estoque, Categoria categoria) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tipo = tipo;
        this.valor = valor;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    // Atualização do método fromDTO usando ModelMapper
    public static Produto fromDTO(ProdutoDTO produtoDTO) {
        // Cria uma instância de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // Mapeia o ProdutoDTO para a entidade Produto
        Produto produto = modelMapper.map(produtoDTO, Produto.class);

        return produto;
    }

    // Método para converter Produto para ProdutoDTO usando ModelMapper
    public ProdutoDTO toDTO() {
        return modelMapper.map(this, ProdutoDTO.class);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Adicionando métodos para ativar e desativar o produto
    public void ativar() {
        this.estoque = true;
    }

    public void desativar() {
        this.estoque = false;
    }

    // Adicionando um método para verificar se o produto está disponível para venda
    public boolean disponivelParaVenda() {
        return estoque; // Retorna true se o produto estiver em estoque
    }

}
