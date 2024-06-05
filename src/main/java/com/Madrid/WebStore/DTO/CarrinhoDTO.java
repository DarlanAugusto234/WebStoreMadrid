package com.Madrid.WebStore.DTO;

import java.util.List;

public class CarrinhoDTO {

    private ClienteDTO clienteDTO;

    private List<ItemVendaDTO> itensDTO;

    private Double total;

    public CarrinhoDTO() {
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public List<ItemVendaDTO> getItensDTO() {
        return itensDTO;
    }

    public void setItensDTO(List<ItemVendaDTO> itensDTO) {
        this.itensDTO = itensDTO;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
