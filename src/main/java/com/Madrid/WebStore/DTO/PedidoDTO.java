package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Enum.StatusPedido;
import com.Madrid.WebStore.Enum.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private ClienteDTO clienteDTO;

    private List<ItemVendaDTO> itensDTO = new ArrayList<>();

    private String endereco;

    private TipoPagamento tipoPagamento;

    private StatusPedido statusPedido;

    private Double valorTotal;

    public PedidoDTO() {
    }

    public PedidoDTO(ClienteDTO clienteDTO, List<ItemVendaDTO> itensDTO, String endereco, TipoPagamento tipoPagamento, StatusPedido statusPedido, Double valorTotal) {
        this.clienteDTO = clienteDTO;
        this.itensDTO = itensDTO;
        this.endereco = endereco;
        this.tipoPagamento = tipoPagamento;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ItemVendaDTO> getItensDTO() {
        return itensDTO;
    }

    public void setItensDTO(List<ItemVendaDTO> itensDTO) {
        this.itensDTO = itensDTO;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
