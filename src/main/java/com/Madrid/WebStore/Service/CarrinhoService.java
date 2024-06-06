package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Carrinho;
import com.Madrid.WebStore.Classes.ItemVenda;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.CarrinhoDTO;
import com.Madrid.WebStore.DTO.ItemVendaDTO;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.ItemVendaRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarrinhoService {

    ProdutoRepositorio produtoRepositorio;

    ItemVendaRepositorio itemVendaRepositorio;

    ModelMapper modelMapper;

    private Carrinho carrinho = new Carrinho();

    public CarrinhoService(ProdutoRepositorio produtoRepositorio, ItemVendaRepositorio itemVendaRepositorio, ModelMapper modelMapper) {
        this.produtoRepositorio = produtoRepositorio;
        this.itemVendaRepositorio = itemVendaRepositorio;
        this.modelMapper = modelMapper;
    }

    // COMENTAR AQUI
    public CarrinhoDTO adicionarProdutoAoCarrinho(Integer id) {
        boolean adicionado = false;
        // Busca o produto pelo ID no banco de dados
        Produto produto = produtoRepositorio.findById(id).orElseThrow();

        // Converte o produto para um ProdutoDTO
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);

        // Verifica se o produto já está no carrinho
        for (ItemVenda item : carrinho.getItens()) {
            if (item.getProduto().getId().equals(produtoDTO.getId())) {
                // Se o produto já está no carrinho, aumenta a quantidade e atualiza o subtotal
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
                item.setSubTotal(item.getQuantidadeDoItem() * produtoDTO.getPreco());
            //    itemVendaRepositorio.save(item);
                adicionado = true;
            }
        }
        if (!adicionado) {
            // Se o produto não está no carrinho, cria um novo item de venda
            ItemVenda novoItem = new ItemVenda();
            novoItem.setProduto(produto);
            novoItem.setQuantidadeDoItem(1);
            novoItem.setSubTotal(produtoDTO.getPreco());
            carrinho.getItens().add(novoItem);
        }
       // itemVendaRepositorio.save(novoItem);
        return montarCarrinho();
    }

    // COMENTAR
    public CarrinhoDTO removerTodosProdutosDoCarrinho() {
        carrinho.limpar();
        return montarCarrinho();
    }

    // COMENTAR
    public CarrinhoDTO aumentarQuantidadeDoProdutoNoCarrinho(Integer id) {
        for (ItemVenda item : carrinho.getItens()) {
            if (item.getProduto().getId().equals(id)) {
                item.setQuantidadeDoItem(item.getQuantidadeDoItem() + 1);
            }
        }
        return montarCarrinho();
    }

    // COMENTAR
    public CarrinhoDTO diminuirQuantidadeDoProdutoNoCarrinho(Integer id) {
        for (ItemVenda item : carrinho.getItens()) {

            if (item.getProduto().getId().equals(id)) {

                if (item.getQuantidadeDoItem() > 1) {
                    item.setQuantidadeDoItem(item.getQuantidadeDoItem() - 1);
                }
            }
        }
        return montarCarrinho();
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }

    // COMENTAR
    public CarrinhoDTO listarItensDoCarrinho() {
        return montarCarrinho();
    }

    private CarrinhoDTO montarCarrinho() {
        // itemVendaRepositorio.save(novoItem);
        CarrinhoDTO crto =  new CarrinhoDTO();

        crto.setTotal(carrinho.getTotal());

        List<ItemVendaDTO> itemVendaDTOS = carrinho.getItens().stream().map(itemVenda -> {
            ItemVendaDTO itemVendaDTO = new ItemVendaDTO();
            itemVendaDTO.setProdutoDTO(modelMapper.map(itemVenda.getProduto(), ProdutoDTO.class));
            itemVendaDTO.setQuantidadeDoItem(itemVenda.getQuantidadeDoItem());
            itemVendaDTO.setSubTotal(itemVenda.getSubTotal());
            return itemVendaDTO;
        }).collect(Collectors.toList());

        crto.setItensDTO(itemVendaDTOS);

        return crto;
    }

    public void removerProdutoDoCarrinho(Integer id) {
        this.carrinho.removerProdutoDoCarrinho(id);
    }
}
