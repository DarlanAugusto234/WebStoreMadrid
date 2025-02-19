package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.DTO.CategoriaDTO;
import com.Madrid.WebStore.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // COMENTAR AQUI
    @PostMapping("/cadastrarCategoria")
    public void cadastrarCategoria(@Valid @RequestBody Categoria categoria) {
        categoriaService.cadastrarCategoria(categoria);
    }

    // COMENTAR AQUI
    @GetMapping("/listarCategorias")
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    // COMENTAR AQUI
    @DeleteMapping("/apagarCategoria/{id}")
    public void apagarCategoria(@PathVariable Integer id) {
        categoriaService.apagarCategoria(id);
    }

    // COMENTAR AQUI
    @GetMapping("/buscarPorNomeCategoria/{nomeCategoria}")
    public List<Categoria> findByNomeCategoria(@PathVariable String nomeCategoria) {
        return categoriaService.findByNomeCategoria(nomeCategoria);
    }

}
