package com.Madrid.WebStore.Classes;

import jakarta.persistence.Embeddable;

import java.util.List;

public class Carrinho {

    private Cliente cliente;

    private List<ItemVenda> itens;

    private double total;

    public Carrinho() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
