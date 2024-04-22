package com.Madrid.WebStore.Classes;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    public String nomeProduto;

    public String cor;

    public String tamanho;

    public String marca;

    public String medidas;

    public String tipo;

    public Double valor;

    public String categoria;

    public boolean ativo;

    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente cliente;

    public Produto(String nomeProduto, String cor, String tamanho, String marca, String medidas, String tipo, Double valor, String categoria, boolean ativo) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.medidas = medidas;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.ativo = false;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

}
