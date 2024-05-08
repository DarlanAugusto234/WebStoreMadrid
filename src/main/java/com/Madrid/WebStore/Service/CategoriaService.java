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

    // Cadastrar ou Atualizar Categoria
    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    // Listar Categoria
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
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
        return categoriaRepositorio.findByNomeCategoria(nomeCategoria);
    }

}
