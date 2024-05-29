package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.ItemVenda;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarrinhoController {

    CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    // COMENTAR
    @GetMapping("/listarItensDoCarrinho")
    public Map<String, Object> listarItensDoCarrinho() {
        List<ItemVenda> itens = carrinhoService.listarItensDoCarrinho();
        double subTotal = carrinhoService.calcularValorItens();

        Map<String, Object> response = new HashMap<>();
        response.put("itensCarrinho", itens);
        response.put("subTotal", subTotal);

        return response;
    }

//    public List<ItemVenda> listarItens() {
//      return carrinhoService.listarItensDoCarrinho();
//    }

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
