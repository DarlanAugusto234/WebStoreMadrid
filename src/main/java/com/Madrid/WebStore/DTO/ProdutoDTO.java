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
    private Double preco;
    @JsonProperty("estoque")
    private Integer quantidadeNoEstoque;
    private boolean destaque;
    private String descricao;
    @JsonIgnore
    private Integer idCategoria;
    @JsonProperty("categoria")
    private String nomeCategoria;
    private String imagem;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tecido, Double preco,
                      Integer quantidadeNoEstoque, boolean destaque, String descricao, Integer idCategoria, String nomeCategoria, String imagem) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tecido = tecido;
        this.preco = preco;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.destaque = destaque;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.imagem = imagem;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @JsonIgnore
    public Integer getIdCategoria() {
        return idCategoria;
    }

    @JsonProperty
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(Integer quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }
}
