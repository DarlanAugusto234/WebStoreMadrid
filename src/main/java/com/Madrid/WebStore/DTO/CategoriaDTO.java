package com.Madrid.WebStore.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CategoriaDTO {

    private String nomeCategoria;
    @JsonIgnore
    private List<ProdutoDTO> produtos;

    public CategoriaDTO() {}

    public CategoriaDTO(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
