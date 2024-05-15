package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Categoria;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

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
        ModelMapper modelMapper = new ModelMapper();
        this.nomeCategoria = categoria.getNomeCategoria();
        this.produtos = modelMapper.map(categoria.getProduto(), new TypeToken() {}.getType());
    }

    // Método estático para converter uma lista de entidades Categoria em uma lista de CategoriaDTOs
    public static List<CategoriaDTO> convert(List<Categoria> categorias) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categorias, new TypeToken<List<CategoriaDTO>>() {}.getType());
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
