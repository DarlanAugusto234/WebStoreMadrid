package com.Madrid.WebStore.DTOService;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.DTO.ClienteDTO;
import com.Madrid.WebStore.Service.ClienteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteDTOService {

    ClienteService clienteService;

    // Método para listar todos os clientes DTO
    public List<ClienteDTO> listarTodosClientesDTO() {
        List<Cliente> clientes = clienteService.listarCliente();
        return clientes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método auxiliar para converter um Cliente em um ClienteDTO
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEndereco(cliente.getEndereco());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setCpf(cliente.getCpf());
        return clienteDTO;
    }

}
