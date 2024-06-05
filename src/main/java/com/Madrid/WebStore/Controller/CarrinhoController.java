package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Carrinho;
import com.Madrid.WebStore.Classes.ItemVenda;
import com.Madrid.WebStore.Service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarrinhoController {

    CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    // COMENTAR
    @GetMapping("/listarItensDoCarrinho")
    public Carrinho listarItensDoCarrinho() {
        Carrinho carrinho = new Carrinho();
        List<ItemVenda> itens = carrinhoService.listarItensDoCarrinho();
        carrinho.setItens(carrinhoService.listarItensDoCarrinho());
        carrinho.setTotal(carrinhoService.calcularValorItens());
        return carrinho;
    }

    @PostMapping("/adicionarItemAoCarrinho/{id}")
    public void adicionarProdutoAoCarrinho(@PathVariable Integer id) {
        carrinhoService.adicionarProdutoAoCarrinho(id);
    }

    @DeleteMapping("/removerItemDoCarrinho/{id}")
    public void removerProdutoDoCarrinho(@PathVariable Integer id) {
        carrinhoService.removerProdutoDoCarrinho(id);
    }

    @DeleteMapping("/removerTodosOsItensDoCarrinho")
    public void removerTodosProdutosDoCarrinho() {
        carrinhoService.removerTodosProdutosDoCarrinho();
    }

    @PostMapping("/aumentarItemNoCarrinho/{id}")
    public void aumentarQuantidadeDoProdutoNoCarrinho(@PathVariable Integer id) {
        carrinhoService.aumentarQuantidadeDoProdutoNoCarrinho(id);
    }

    @PostMapping("/diminuirItemNoCarrinho/{id}")
    public void diminuirQuantidadeDoProdutoNoCarrinho(@PathVariable Integer id) {
        carrinhoService.diminuirQuantidadeDoProdutoNoCarrinho(id);
    }

}
