package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Classes.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

<<<<<<< HEAD
    private String nomeProduto;
    private String cor;
    private String tamanho;
    private String marca;
    private String tipo;
    private Double valor;
    private Integer idCategoria;
    private boolean estoque;
=======
    public String nomeProduto;
    public String cor;
    public String tamanho;
    public String marca;
    public String tipo;
    public Double valor;

    public Categoria categoria;
    public boolean estoque;
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41

    public ProdutoDTO() {
    }

<<<<<<< HEAD
    // Construtor com todos os atributos
    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tipo,
                      Double valor, boolean estoque, Integer idCategoria) {
=======
    // Construtor para inicializar os atributos do ProdutoDTO com os valores
    // especificados


    public ProdutoDTO(String nomeProduto, String cor, String tamanho, String marca, String tipo,
                      Double valor, Categoria categoria, boolean estoque) {
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tipo = tipo;
        this.valor = valor;
        this.estoque = estoque;
        this.idCategoria = idCategoria;
    }

    // Construtor de cópia para criar um novo ProdutoDTO a partir de outro
    // ProdutoDTO fornecido
    public ProdutoDTO(ProdutoDTO produtoDTO) {
        this.idCategoria = produtoDTO.idCategoria;
        this.nomeProduto = produtoDTO.nomeProduto;
        this.cor = produtoDTO.cor;
        this.tamanho = produtoDTO.tamanho;
        this.marca = produtoDTO.marca;
        this.tipo = produtoDTO.tipo;
        this.valor = produtoDTO.valor;
        this.estoque = produtoDTO.estoque;
    }

    // Construtor da classe ProdutoDTO que inicializa seus atributos com os valores
    // correspondentes do objeto Produto fornecido
    public ProdutoDTO(Produto produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.cor = produto.getCor();
        this.tamanho = produto.getTamanho();
        this.marca = produto.getMarca();
        this.tipo = produto.getTipo();
        this.valor = produto.getValor();
        this.estoque = produto.isEstoque();
    }


    // Método estático para converter uma lista de objetos ProdutoDTO em uma nova
    // lista de ProdutoDTOs
    public static List<ProdutoDTO> convert(List<ProdutoDTO> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

<<<<<<< HEAD
=======
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

}
