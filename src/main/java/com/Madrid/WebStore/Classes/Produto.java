// Produto.java
package com.Madrid.WebStore.Classes;

<<<<<<< HEAD
import com.Madrid.WebStore.DTO.ProdutoDTO;
=======
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
<<<<<<< HEAD
=======

    private String medidas;
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41

    @NotBlank
    private String tipo;

    @NotNull
    private Double valor;

    public boolean estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Cliente> cliente;

    public Produto(Integer id, String nomeProduto, String cor, String tamanho, String marca,
<<<<<<< HEAD
                   String tipo, Double valor, boolean estoque, Categoria categoria) {
=======
                   String medidas, String tipo, Double valor, boolean estoque, Categoria categoria) {
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tipo = tipo;
        this.valor = valor;
        this.estoque = estoque;
        this.categoria = categoria;
<<<<<<< HEAD
    }

    public static Produto fromDTO(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setCor(produtoDTO.getCor());
        produto.setTamanho(produtoDTO.getTamanho());
        produto.setMarca(produtoDTO.getMarca());
        produto.setTipo(produtoDTO.getTipo());
        produto.setValor(produtoDTO.getValor());
        produto.setEstoque(produtoDTO.isEstoque());
        return produto;
=======
>>>>>>> 001401adf9a8e6441ac523a6cefa1a36752c6f41
    }

    public Produto() {
    }

    public Produto(ProdutoDTO produtoDTO) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
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
        return estoque = estoque;
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
