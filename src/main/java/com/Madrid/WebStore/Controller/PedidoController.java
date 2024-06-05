package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.Classes.Pedido;
import com.Madrid.WebStore.DTO.PedidoDTO;
import com.Madrid.WebStore.Enum.StatusPedido;
import com.Madrid.WebStore.Service.PedidoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/fazerPedido/{clienteId}")
    public PedidoDTO cadastrarPedido(@RequestBody PedidoDTO pedidoDTO, @PathVariable Integer clienteId) {
        pedidoDTO.setStatusPedido(StatusPedido.ACEITO);
        return pedidoService.cadastrarPedido(pedidoDTO, clienteId);
    }

}
