package com.Madrid.WebStore.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoDTO {
<<<<<<< HEAD
    @JsonIgnore
    private Integer id;
=======

>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    private String nomeProduto;
    private String cor;
    private String tamanho;
    private String marca;
    private String tecido;
    private Double valor;
<<<<<<< HEAD
    private Integer quantidadeNoEstoque;
    private boolean destaque;
=======
    private Integer estoque;
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    @JsonIgnore
    private Integer idCategoria;
    private CategoriaDTO categoria;

    public ProdutoDTO() {
    }

<<<<<<< HEAD
    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tecido, Double valor,
                      Integer quantidadeNoEstoque, boolean destaque, Integer idCategoria, CategoriaDTO categoria) {
=======
    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tecido,
                      Double valor, Integer estoque, Integer idCategoria, CategoriaDTO categoria) {
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tecido = tecido;
        this.valor = valor;
<<<<<<< HEAD
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.destaque = destaque;
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

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
=======
        this.estoque = estoque;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
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

<<<<<<< HEAD
    public Integer getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(Integer quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
=======
    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    }
}
