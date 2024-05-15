package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.DTO.CategoriaDTO;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    CategoriaRepositorio categoriaRepositorio;

    ModelMapper modelMapper;

    public CategoriaService(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    // Cadastrar ou Atualizar Categoria
    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    // Listar Categoria
    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepositorio.findAll();
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();

        for (Categoria categoria : categorias) {
            CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
            categoriasDTO.add(categoriaDTO);
        }

        return categoriasDTO;
    }

    // Apagar Categorias
    public void apagarCategoria(Integer id) {
        categoriaRepositorio.deleteById(id);
    }

    // Procurar Pelo Id a Categoria
    public Categoria procurarPeloId(Integer categoriaId) {
        return categoriaRepositorio.findById(categoriaId).orElseThrow();
    }

    // Listar Todas as Categorias pelo Nome
    public List<Categoria> findByNomeCategoria(String nomeCategoria) {
        return categoriaRepositorio.findByNomeCategoriaContainingIgnoreCase(nomeCategoria);
    }

}
