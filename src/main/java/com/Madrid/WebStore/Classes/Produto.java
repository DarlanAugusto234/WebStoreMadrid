package com.Madrid.WebStore.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
<<<<<<< HEAD
    @Pattern(regexp = "^[PMGX]{1,3}$", message = "Tamanho deve ser P, M, G, GG ou XGG")
=======
    @Pattern(regexp = "^[PMLGX]{1,3}$", message = "Tamanho deve ser P, M, G, GG ou XGG")
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    private String tamanho;

    @NotBlank(message = "A Marca não pode estar em branco")
    private String marca;

    @NotBlank(message = "O Tecido não pode estar em branco")
    private String tecido;

<<<<<<< HEAD
    @NotNull
    private Double valor;

    @NotNull
    private Integer quantidadeNoEstoque;

    @Column(nullable = false)
    private boolean destaque;
=======
    @NotNull(message = "O Valor não pode ser nulo")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "O Valor deve ser um número válido com até duas casas decimais")
    private Double valor;

    @NotBlank
    @Min(value = 0, message = "O estoque deve ser um número inteiro não negativo")
    private Integer estoque;
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Cliente> clientes;

    public Produto() {
    }

<<<<<<< HEAD
    public Produto(String nomeProduto, String cor, String tamanho, String marca, String tecido, Double valor,
                   Integer quantidadeNoEstoque, boolean destaque, Categoria categoria, List<Cliente> clientes) {
=======
    // Utilizando construtor para inicializar todos os atributos da classe

    public Produto(String nomeProduto, String cor, String tamanho, String marca, String tecido,
                   Double valor, Integer estoque, Categoria categoria, List<Cliente> clientes) {
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
        this.nomeProduto = nomeProduto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tecido = tecido;
        this.valor = valor;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.destaque = destaque;
        this.categoria = categoria;
        this.clientes = clientes;
    }

<<<<<<< HEAD
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
=======
    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
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
<<<<<<< HEAD
        return quantidadeNoEstoque; // Retorna true se o produto estiver em quantidadeNoEstoque
=======
        return estoque; // Retorna true se o produto estiver em estoque
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    }

}
