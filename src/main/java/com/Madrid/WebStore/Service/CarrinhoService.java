package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Carrinho;
import com.Madrid.WebStore.Classes.ItemVenda;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.ItemVendaRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    ProdutoRepositorio produtoRepositorio;

    ItemVendaRepositorio itemVendaRepositorio;

    ModelMapper modelMapper;

    private final List<ItemVenda> itens = new ArrayList<>();

    public CarrinhoService(ProdutoRepositorio produtoRepositorio, ItemVendaRepositorio itemVendaRepositorio, ModelMapper modelMapper) {
        this.produtoRepositorio = produtoRepositorio;
        this.itemVendaRepositorio = itemVendaRepositorio;
        this.modelMapper = modelMapper;
    }

    // COMENTAR AQUI
    public void adicionarProdutoAoCarrinho(Integer id) {
        // Busca o produto pelo ID no banco de dados
        Produto produto = produtoRepositorio.findById(id).orElseThrow();

        // Converte o produto para um ProdutoDTO
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);

        // Verifica se o produto já está no carrinho
        for (ItemVenda item : itens) {
            if (item.getProduto().getId().equals(produtoDTO.getId())) {
                // Se o produto já está no carrinho, aumenta a quantidade e atualiza o subtotal
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
                item.setSubTotal(item.getQuantidadeDoItem() * produtoDTO.getPreco());
                itemVendaRepositorio.save(item);
                return;
            }
        }

        // Se o produto não está no carrinho, cria um novo item de venda
        ItemVenda novoItem = new ItemVenda();
        novoItem.setProduto(produto);
        novoItem.setQuantidadeDoItem(1);
        novoItem.setSubTotal(produtoDTO.getPreco());
        itens.add(novoItem);

        itemVendaRepositorio.save(novoItem);
    }

    // COMENTAR
    public void removerProdutoDoCarrinho(Integer id) {
        for (int i = 0; i < itens.size(); i++) {

            ItemVenda item = itens.get(i);
            if (item.getProduto().getId().equals(id)) {

                if (item.getQuantidadeDoItem() > 1) {
                    item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                    item.setSubTotal(item.getQuantidadeDoItem() * item.getProduto().getPreco());
                }

                else {
                    itens.remove(i);
                }
                calcularValorItens();
                break; // Produto encontrado e removido ou atualizado, saímos do loop
            }
        }
    }

    // COMENTAR
    public Carrinho removerTodosProdutosDoCarrinho() {
        itens.clear();
        calcularValorItens();
        return null;
    }

    // COMENTAR
    public void aumentarQuantidadeDoProdutoNoCarrinho(Integer id) {
        for (ItemVenda item : itens) {

            if (item.getProduto().getId().equals(id)) {
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
                calcularValorItens();
                return;
            }

        }
    }

    // COMENTAR
    public void diminuirQuantidadeDoProdutoNoCarrinho(Integer id) {
        for (ItemVenda item : itens) {

            if (item.getProduto().getId().equals(id)) {

                if (item.getQuantidadeDoItem() > 1) {
                    item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                }

                calcularValorItens();
                return;
            }

        }
    }

    // COMENTAR
    public List<ItemVenda> listarItensDoCarrinho() {
        return itens;
    }

    // COMENTAR
    public double calcularValorItens() {
        double valorItens = 0.0;

        for (ItemVenda item : itens) {
            valorItens += item.getQuantidadeDoItem() * item.getProduto().getPreco();
        }

        return valorItens;
    }

}
