// Produto.java
package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    public String nomeProduto;

    @NotBlank
    public String cor;

    @NotBlank
    public String tamanho;

    @NotBlank
    public String marca;

    public String medidas;

    @NotBlank
    public String tipo;

    @NotBlank
    public Double valor;

    @NotBlank
    public String categoria;

    public boolean estoque;

    @ManyToMany(mappedBy = "produto")
    private List<Cliente> cliente;

    public Produto(String nomeProduto, String cor, String tamanho, String marca, String medidas, String tipo, Double valor, String categoria, boolean estoque) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.medidas = medidas;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.estoque = true;
    }

    public Produto() {
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

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEstoque() {
        return estoque;
    }

    // Adicionando um método para verificar se o produto está disponível para venda
    public boolean disponivelParaVenda() {
        return estoque; // Retorna true se o produto estiver em estoque
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public void ativar() {
        this.estoque = true;
    }

    public void desativar() {
        this.estoque = false;
    }
}
