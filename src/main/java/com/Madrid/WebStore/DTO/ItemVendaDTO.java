package com.Madrid.WebStore.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemVendaDTO {

    private ProdutoDTO produtoDTO;

    private Double subTotal;

    private Integer quantidadeDoItem;

    @JsonIgnore
    private PedidoDTO pedidoDTO;

    public ItemVendaDTO() {
    }

    public ItemVendaDTO(ProdutoDTO produtoDTO, Double subTotal, Integer quantidadeDoItem, PedidoDTO pedidoDTO) {
        this.produtoDTO = produtoDTO;
        this.subTotal = subTotal;
        this.quantidadeDoItem = quantidadeDoItem;
        this.pedidoDTO = pedidoDTO;
    }

    public PedidoDTO getPedidoDTO() {
        return pedidoDTO;
    }

    public void setPedidoDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public ProdutoDTO getProdutoDTO() {
        return produtoDTO;
    }

    public void setProdutoDTO(ProdutoDTO produtoDTO) {
        this.produtoDTO = produtoDTO;
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
