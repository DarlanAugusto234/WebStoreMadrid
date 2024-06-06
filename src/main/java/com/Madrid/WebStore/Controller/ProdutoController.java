package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Cadastrar Produto
    @PostMapping("/cadastrarProduto")
    public void cadastrarProduto(@RequestPart("imagem") MultipartFile imagem, @RequestPart("produto") ProdutoDTO produtoDTO) throws IOException {
        if(!imagem.isEmpty()){
            byte[] bytes = imagem.getBytes();
            String nomeArquivo = imagem.getOriginalFilename();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\ALPHA_INF\\Desktop\\WebStore\\ImagensRoupas\\"+nomeArquivo));
            stream.write(bytes);
            stream.close();
            produtoDTO.setImagem(nomeArquivo);
        }
        produtoService.cadastrarProduto(produtoDTO);
    }

    // Deletar Produto pelo Id
    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
    }

    // Listar Todos os Produtos
    @GetMapping("/listarTodosProdutos")
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarTodos();
    }

    // Procurar Produto pelo Nome
    @GetMapping("/procurarProdutoPeloNome/{nome}")
    public List<ProdutoDTO> procurarProdutoPorNome(@PathVariable String nome) {
        return produtoService.procurarProdutoPorNome(nome);
    }

    // COMENTAR AQUI
    @PutMapping("/alterarTrueOrFalseDestaque/{id}")
    public void alternarDestaqueProduto(@PathVariable Integer id) {
        produtoService.alternarDestaqueProduto(id);
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarPorMaiorValor")
    public List<ProdutoDTO> listarProdutosMaiorValor() {
        return produtoService.listarProdutosMaiorValor();
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarPorMenorValor")
    public List<ProdutoDTO> listarProdutosMenorValor() {
        return produtoService.listarProdutosMenorValor();
    }

}
