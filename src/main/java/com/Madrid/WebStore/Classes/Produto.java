package com.Madrid.WebStore.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O Nome do produto não pode estar em branco")
    private String nomeProduto;

    @NotBlank(message = "A Cor não pode estar em branco")
    private String cor;

    @NotBlank(message = "Tamanho não pode estar em branco")
    @Pattern(regexp = "^[PMGX]{1,3}$", message = "Tamanho deve ser P, M, G, GG ou XGG")
    private String tamanho;

    @NotBlank(message = "A Marca não pode estar em branco")
    private String marca;

    @NotBlank(message = "O Tecido não pode estar em branco")
    private String tecido;

    @NotNull
    private Double valor;

    @NotNull
    private Integer quantidadeNoEstoque;

    @Column(nullable = false)
    private boolean destaque;

    @NotBlank(message = "A Descrição do Produto não pode estar branco")
    @Size(min = 60, max = 260, message = "A Descrição tem que ter no Min 60 e no Max 260 caracteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Cliente> clientes;

    public Produto() {
    }

    public Produto(String nomeProduto, String cor, String tamanho, String marca, String tecido, Double valor, Integer quantidadeNoEstoque,
                   boolean destaque, String descricao, Categoria categoria, List<Cliente> clientes) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tecido = tecido;
        this.valor = valor;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.destaque = destaque;
        this.descricao = descricao;
        this.categoria = categoria;
        this.clientes = clientes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public Integer getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(Integer quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
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

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    // Adicionando um método para verificar se o produto está disponível para venda
    public Integer disponivelParaVenda() {
        return quantidadeNoEstoque; // Retorna true se o produto estiver em quantidadeNoEstoque
    }

}
