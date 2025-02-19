package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
        // Verifica se a categoria foi especificada
        if (produtoDTO.getIdCategoria() == null) {
            throw new IllegalArgumentException("Id da categoria não pode ser nulo.");
        }

        // Busca a categoria no banco de dados
        Categoria categoria = categoriaRepositorio.findById(produtoDTO.getIdCategoria()).orElseThrow();

        Produto produto;
        if (produtoDTO.getId() != null) {
            // Se o ID do produto está presente, trata-se de uma atualização
            produto = produtoRepositorio.findById(produtoDTO.getId()).orElseThrow();
            modelMapper.map(produtoDTO, produto); // Atualiza o produto existente com os valores do DTO
        }

        else {
            // Caso contrário, cria um novo produto
            produto = modelMapper.map(produtoDTO, Produto.class);
        }

        // Define a categoria do produto
        produto.setCategoria(categoria);

        // Salva o produto no banco de dados
        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = produtoRepositorio.findAll();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtosDTO.add(produtoDTO);
        }

        return produtosDTO;
    }

    // Procurar Produto pelo Nome
    public List<ProdutoDTO> procurarProdutoPorNome(String nomeProduto) {
        List<Produto> produtos = produtoRepositorio.findByNomeProdutoContainingIgnoreCase(nomeProduto);
        List<ProdutoDTO> produtoDTOs = new ArrayList<>();

        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtoDTOs.add(produtoDTO);
        }

        return produtoDTOs;
    }

    // COMENTAR AQUI
    public void alternarDestaqueProduto(Integer id) {
        Produto produto = produtoRepositorio.findById(id).orElseThrow();
        produto.setDestaque(!produto.isDestaque());
        produtoRepositorio.save(produto);
    }

    // Método para listar produtos por maior valor
    public List<ProdutoDTO> listarProdutosMaiorValor() {
        List<Produto> produtos = produtoRepositorio.findAllByOrderByPrecoDesc();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtosDTO.add(produtoDTO);
        }
        return produtosDTO;
    }

    // Método para listar produtos por menor valor
    public List<ProdutoDTO> listarProdutosMenorValor() {
        List<Produto> produtos = produtoRepositorio.findAllByOrderByPrecoAsc();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtosDTO.add(produtoDTO);
        }
        return produtosDTO;
    }

    // Deletar Produto Pelo Id
    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

}
