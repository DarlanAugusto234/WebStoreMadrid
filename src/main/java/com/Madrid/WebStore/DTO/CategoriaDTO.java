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

    // Construtor para converter uma entidade Categoria em CategoriaDTO
    public CategoriaDTO(Categoria categoria) {
        this.nomeCategoria = categoria.getNomeCategoria();
        this.produtos = categoria.getProduto().stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    // Método estático para converter uma lista de entidades Categoria em uma lista de CategoriaDTOs
    public static List<CategoriaDTO> convert(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    // Getters e setters
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
