package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarProdutosOuCategorias/{query}")
    public List<ProdutoDTO> pesquisarProdutos(@PathVariable String query) {
        return homeService.pesquisarProdutos(query);
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarDestaques")
    public List<ProdutoDTO> listarProdutosDestaque() {
        return homeService.listarProdutosDestaque();
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarPorMaiorValor")
    public List<ProdutoDTO> listarProdutosMaiorValor() {
        return homeService.listarProdutosMaiorValor();
    }

    // COMENTAR AQUI
    @GetMapping("/pesquisarPorMenorValor")
    public List<ProdutoDTO> listarProdutosMenorValor() {
        return homeService.listarProdutosMenorValor();
    }

}
