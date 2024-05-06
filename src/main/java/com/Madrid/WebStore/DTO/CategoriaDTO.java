package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDTO {

    private String nomeCategoria;

    private List<ProdutoDTO> produtos;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaDTO(Categoria categoria) {
        nomeCategoria = categoria.getNomeCategoria();
        produtos = categoria.getProduto().stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    // COMENTAR AQUI
    public static List<CategoriaDTO> convert(List<Categoria> categoria) {
        return categoria.stream().map(CategoriaDTO::new).collect(Collectors.toList());
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
