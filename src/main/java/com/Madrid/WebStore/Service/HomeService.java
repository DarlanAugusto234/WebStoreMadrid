package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.DTO.ProdutoResumoDTO;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HomeService {

    CategoriaRepositorio categoriaRepositorio;
    ProdutoRepositorio produtoRepositorio;
    ModelMapper modelMapper;

    public HomeService(CategoriaRepositorio categoriaRepositorio, ProdutoRepositorio produtoRepositorio, ModelMapper modelMapper) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.modelMapper = modelMapper;
    }

    // Metodo de Barra de Pesquisa
    public List<ProdutoDTO> pesquisarProdutos(String query) {
        // Usar um Set para evitar duplicatas
        Set<Produto> produtos = new HashSet<>(produtoRepositorio.findByNomeProdutoContainingIgnoreCase(query));
        produtos.addAll(produtoRepositorio.findByCorContainingIgnoreCase(query));
        produtos.addAll(produtoRepositorio.findByMarcaContainingIgnoreCase(query));
        produtos.addAll(produtoRepositorio.findByTecidoContainingIgnoreCase(query));
        produtos.addAll(produtoRepositorio.findByCategoriaNomeCategoriaContainingIgnoreCase(query));
        produtos.addAll(produtoRepositorio.findByTamanhoContainingIgnoreCase(query));

        // Converter Set de produtos para List de ProdutoDTO
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtosDTO.add(produtoDTO);
        }

        return produtosDTO;
    }

    // Método para listar produtos em destaque
    public List<ProdutoDTO> listarProdutosDestaque() {
        List<Produto> produtos = produtoRepositorio.findByDestaqueTrue();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            produtosDTO.add(produtoDTO);
        }
        return produtosDTO;
    }

    // Codigo para Teste de Segunda Feira
    /*
    public List<ProdutoResumoDTO> listarProdutosDestaque() {
        List<Produto> produtos = produtoRepositorio.findByDestaqueTrue();
        List<ProdutoResumoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoResumoDTO produtoResumoDTO = new ProdutoResumoDTO();
            produtoResumoDTO.setNomeProduto(produto.getNomeProduto());
            produtoResumoDTO.setCategoria(produto.getCategoria().getNomeCategoria());
            produtoResumoDTO.setValor(produto.getValor());
            produtoResumoDTO.setDescricao(produto.getDescricao());
            produtosDTO.add(produtoResumoDTO);
        }
        return produtosDTO;
    }
    */

    // Método para buscar um produto em destaque pelo ID
    public ProdutoResumoDTO buscarProdutoPorId(Integer id) {
        Produto produto = produtoRepositorio.findById(id).orElseThrow();

        ProdutoResumoDTO produtoResumoDTO = new ProdutoResumoDTO();
        produtoResumoDTO.setNomeProduto(produto.getNomeProduto());
        produtoResumoDTO.setCategoria(produto.getCategoria().getNomeCategoria());
        produtoResumoDTO.setValor(produto.getValor());
        produtoResumoDTO.setDescricao(produto.getDescricao());

        return produtoResumoDTO;
    }

}
