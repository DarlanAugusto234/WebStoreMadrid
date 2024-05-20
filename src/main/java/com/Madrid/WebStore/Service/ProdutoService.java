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

import java.util.ArrayList;
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
<<<<<<< HEAD
        // Verifica se a categoria foi especificada
        if (produtoDTO.getIdCategoria() == null) {
            throw new IllegalArgumentException("Id da categoria não pode ser nulo.");
        }

        // Busca a categoria no banco de dados
        Categoria categoria = categoriaRepositorio.findById(produtoDTO.getIdCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada para o id: " + produtoDTO.getIdCategoria()));

        Produto produto;
        if (produtoDTO.getId() != null) {
            // Se o ID do produto está presente, trata-se de uma atualização
            produto = produtoRepositorio.findById(produtoDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado para o id: " + produtoDTO.getId()));
            modelMapper.map(produtoDTO, produto); // Atualiza o produto existente com os valores do DTO
        } else {
            // Caso contrário, cria um novo produto
            produto = modelMapper.map(produtoDTO, Produto.class);
        }

        // Define a categoria do produto
        produto.setCategoria(categoria);

        // Salva o produto no banco de dados
=======
        if (produtoDTO.getIdCategoria() == null) {}

        Categoria categoria = categoriaRepositorio.findById(produtoDTO.getIdCategoria()).orElseThrow();

        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setCategoria(categoria);

>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<ProdutoDTO> listarTodos() {
<<<<<<< HEAD
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
=======
        return produtoRepositorio.findAll().stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    // Procurar Produto pelo Nome
    public List<ProdutoDTO> procurarProdutoPorNome(String nome) {
        return produtoRepositorio.findByNomeProduto(nome);
>>>>>>> be03bde298195dfb20c8279c92e7bb80d5668c30
    }

    // Deletar Produto Pelo Id
    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

}
