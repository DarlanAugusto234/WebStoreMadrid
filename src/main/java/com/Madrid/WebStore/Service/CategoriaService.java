package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    CategoriaRepositorio categoriaRepositorio;

    public CategoriaService(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    // COMENTAR AQUI
    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    // COMENTAR AQUI
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
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
        return categoriaRepositorio.findByNomeCategoria(nomeCategoria);
    }

}
