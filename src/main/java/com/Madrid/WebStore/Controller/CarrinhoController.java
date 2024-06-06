package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Carrinho;
import com.Madrid.WebStore.Classes.ItemVenda;
import com.Madrid.WebStore.DTO.CarrinhoDTO;
import com.Madrid.WebStore.DTO.ItemVendaDTO;
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
    public CarrinhoDTO listarItensDoCarrinho() {
        return carrinhoService.listarItensDoCarrinho();
    }

    @PostMapping("/adicionarItemAoCarrinho/{id}")
    public CarrinhoDTO adicionarProdutoAoCarrinho(@PathVariable Integer id) {
       return carrinhoService.adicionarProdutoAoCarrinho(id);
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
