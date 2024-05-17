package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.CategoriaDTO;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    ProdutoRepositorio produtoRepositorio;

    ClienteRepositorio clienteRepositorio;

    CategoriaRepositorio categoriaRepositorio;

    ModelMapper modelMapper;

    public ProdutoService(ProdutoRepositorio produtoRepositorio, ClienteRepositorio clienteRepositorio,
                          CategoriaRepositorio categoriaRepositorio, ModelMapper modelMapper) {
        this.produtoRepositorio = produtoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
        this.modelMapper = modelMapper;
    }

    // Cadastrar Produto ou Atualizar
    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO.getIdCategoria() == null) {}

        Categoria categoria = categoriaRepositorio.findById(produtoDTO.getIdCategoria()).orElseThrow();

        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setCategoria(categoria);

        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<ProdutoDTO> listarTodos() {
        return produtoRepositorio.findAll().stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    // Procurar Produto pelo Nome
    public List<ProdutoDTO> procurarProdutoPorNome(String nome) {
        return produtoRepositorio.findByNomeProduto(nome);
    }

    // Deletar Produto Pelo Id
    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

}
