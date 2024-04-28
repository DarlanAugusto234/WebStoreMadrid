package com.Madrid.WebStore.DTOController;

import com.Madrid.WebStore.DTO.ClienteDTO;
import com.Madrid.WebStore.DTOService.ClienteDTOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClienteDTOController {

    ClienteDTOService clienteDTOService;

    public ClienteDTOController(ClienteDTOService clienteDTOService) {
        this.clienteDTOService = clienteDTOService;
    }

    @GetMapping("/listarTodosClienteDTO")
    public List<ClienteDTO> listarTodosClientesDTO() {
        return clienteDTOService.listarTodosClientesDTO();
    }

}
