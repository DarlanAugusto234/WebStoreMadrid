package com.Madrid.WebStore.Classes;

import jakarta.persistence.Embeddable;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Cliente cliente;

    private List<ItemVenda> itens;

    public Carrinho() {
        itens = new ArrayList<>();
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
        double valorItens = 0.0;

        for (ItemVenda item : itens) {
            valorItens += item.getQuantidadeDoItem() * item.getProduto().getPreco();
        }

        return valorItens;
    }

    public void removerProdutoDoCarrinho(Integer id) {
        for (int i = 0; i < this.getItens().size(); i++) {

            ItemVenda item = this.getItens().get(i);
            if (item.getProduto().getId().equals(id)) {

                if (item.getQuantidadeDoItem() > 1) {
                    item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                    item.setSubTotal(item.getQuantidadeDoItem() * item.getProduto().getPreco());
                }

                else {
                    this.itens.remove(i);
                }
                break; // Produto encontrado e removido ou atualizado, saímos do loop
            }
        }
    }

    public void limpar() {
        this.itens.clear();
    }
}
