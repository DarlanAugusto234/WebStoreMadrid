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

    public CategoriaService(CategoriaRepositorio categoriaRepositorio, ModelMapper modelMapper) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.modelMapper = modelMapper;
    }

    // COMENTAR AQUI
    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    // COMENTAR AQUI
    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepositorio.findAll();
        List<CategoriaDTO> categoriaDTOs = new ArrayList<>();

        for (Categoria categoria : categorias) {
            CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
            categoriaDTOs.add(categoriaDTO);
        }

        return categoriaDTOs;
    }

    // COMENTAR AQUI
    public void apagarCategoria(Integer id) {
        categoriaRepositorio.deleteById(id);
    }

    // COMENTAR AQUI
    public Categoria procurarPeloId(Integer categoriaId) {
        return categoriaRepositorio.findById(categoriaId).orElseThrow();
    }

    // COMENTAR AQUI
    public List<Categoria> findByNomeCategoria(String nomeCategoria) {
        return categoriaRepositorio.findByNomeCategoriaContainingIgnoreCase(nomeCategoria);
    }

}
