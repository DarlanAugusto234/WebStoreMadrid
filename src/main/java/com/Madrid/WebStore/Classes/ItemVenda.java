package com.Madrid.WebStore.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Produto produto;

    private Double subTotal;

    private Integer quantidadeDoItem;

    @ManyToOne
    private Pedido pedido;

    public ItemVenda() {
    }

    public ItemVenda(Produto produto, Double subTotal, Integer quantidadeDoItem, Pedido pedido) {
        this.produto = produto;
        this.subTotal = subTotal;
        this.quantidadeDoItem = quantidadeDoItem;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public void setQuantidadeDoItem(Integer quantidadeDoItem) {
        this.quantidadeDoItem = quantidadeDoItem;
    }

}
