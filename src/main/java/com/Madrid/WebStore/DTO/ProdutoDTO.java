package com.Madrid.WebStore.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoDTO {
    @JsonIgnore
    private Integer id;
    private String nomeProduto;
    private String cor;
    private String tamanho;
    private String marca;
    private String tecido;
    private Double valor;
    private Integer quantidadeNoEstoque;
    private boolean destaque;
    private String descricao;
    @JsonIgnore
    private Integer idCategoria;
    private CategoriaDTO categoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tecido, Double valor,
                      Integer quantidadeNoEstoque, boolean destaque, String descricao, Integer idCategoria, CategoriaDTO categoria) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tecido = tecido;
        this.valor = valor;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.destaque = destaque;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
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

    @JsonIgnore
    public Integer getIdCategoria() {
        return idCategoria;
    }

    @JsonProperty
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(Integer quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }
}
