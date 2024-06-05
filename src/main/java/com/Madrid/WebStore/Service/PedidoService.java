package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.*;
import com.Madrid.WebStore.DTO.ClienteDTO;
import com.Madrid.WebStore.DTO.ItemVendaDTO;
import com.Madrid.WebStore.DTO.PedidoDTO;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ItemVendaRepositorio;
import com.Madrid.WebStore.Repositorios.PedidoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    PedidoRepositorio pedidoRepositorio;

    ClienteRepositorio clienteRepositorio;

    CarrinhoService carrinhoService;

    ItemVendaRepositorio itemVendaRepositorio;

    ModelMapper modelMapper;

    public PedidoService(PedidoRepositorio pedidoRepositorio, ClienteRepositorio clienteRepositorio, CarrinhoService carrinhoService, ItemVendaRepositorio itemVendaRepositorio, ModelMapper modelMapper) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.carrinhoService = carrinhoService;
        this.itemVendaRepositorio = itemVendaRepositorio;
        this.modelMapper = modelMapper;
    }

    public PedidoDTO cadastrarPedido(PedidoDTO pedidoDTO, Integer clienteId) {
        // Verifica o cliente pelo ID
        Cliente cliente = clienteRepositorio.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Converte PedidoDTO para Pedido
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setCliente(cliente);

        // Inicializa a lista de itens se estiver nula
        if (pedido.getItens() == null) {
            pedido.setItens(new ArrayList<>());
        }

        // Associa cada ItemVenda ao pedido e obtém os itens do PedidoDTO
        for (ItemVendaDTO itemVendaDTO : pedidoDTO.getItensDTO()) {
            ItemVenda itemVenda = modelMapper.map(itemVendaDTO, ItemVenda.class);
            itemVenda.setPedido(pedido);
            pedido.getItens().add(itemVenda);
        }

        // Calcula o valor total do pedido
        double valorTotal = pedido.getItens().stream().mapToDouble(ItemVenda::getSubTotal).sum();
        pedido.setValorTotal(valorTotal);

        // Salva o pedido no banco de dados
        pedidoRepositorio.save(pedido);

        // Limpa os itens do carrinho
        carrinhoService.removerTodosProdutosDoCarrinho();

        // Converte o Pedido de volta para PedidoDTO antes de retornar
        PedidoDTO retornoDTO = modelMapper.map(pedido, PedidoDTO.class);

        // Configura o ClienteDTO no PedidoDTO de retorno
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        retornoDTO.setClienteDTO(clienteDTO);

        return retornoDTO;
    }
}

