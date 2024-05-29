package com.Madrid.WebStore.Classes;

import com.Madrid.WebStore.DTO.ProdutoDTO;

public class ItemVenda {

    private ProdutoDTO produto;
    private Double valorItens;
    private Integer quantidadeDoItem;

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Double getValorItens() {
        return valorItens;
    }

    public void setValorItens(Double valorItens) {
        this.valorItens = valorItens;
    }

    public Integer getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public void setQuantidadeDoItem(Integer quantidadeDoItem) {
        this.quantidadeDoItem = quantidadeDoItem;
    }
}
