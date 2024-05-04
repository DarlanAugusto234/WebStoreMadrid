package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    public String nomeProduto;
    public String cor;
    public String tamanho;
    public String marca;
    public String tipo;
    public Double valor;
    public String categoria;
    public boolean estoque;

    public ProdutoDTO() {
    }

    // FALTANDO COMENTARIO
    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tipo, Double valor, String categoria, boolean estoque) {
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    // FALTANDO COMENTARIO
    public ProdutoDTO(ProdutoDTO produtoDTO) {
        this.nomeProduto = produtoDTO.nomeProduto;
        this.cor = produtoDTO.cor;
        this.tamanho = produtoDTO.tamanho;
        this.marca = produtoDTO.marca;
        this.tipo = produtoDTO.tipo;
        this.valor = produtoDTO.valor;
        this.categoria = produtoDTO.categoria;
        this.estoque = produtoDTO.estoque;
    }

    // FALTANDO COMENTARIO
    public ProdutoDTO(Produto produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.cor = produto.getCor();
        this.tamanho = produto.getTamanho();
        this.marca = produto.getMarca();
        this.tipo = produto.getTipo();
        this.valor = produto.getValor();
        this.categoria = produto.getCategoria();
        this.estoque = produto.isEstoque();
    }

    // FALTANDO COMENTARIO
    public static List<ProdutoDTO> convert(List<ProdutoDTO> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

}
