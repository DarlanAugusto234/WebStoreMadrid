package com.Madrid.WebStore.Controller;

import com.Madrid.WebStore.DTO.FuncionarioDTO;
import com.Madrid.WebStore.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionarioController {

    FuncionarioService funcionarioService;

    ModelMapper modelMapper;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Cadastrar e Atualizar Funcionarios
    @PostMapping("/cadastrarFuncionario")
    public void cadastroFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.cadastrarFuncionario(funcionarioDTO);
    }

    // Listar todos os Funcionarios
    @GetMapping("/listarTodosOsFuncionarios")
    public List<FuncionarioDTO> listarTodosFuncionarios() {
        return funcionarioService.listarTodosFuncionarios();
    }

    // Procurar Funcionario pelo Nome
    @GetMapping("/procurarFuncionarioPeloNome/{nome}")
    public List<FuncionarioDTO> getFuncionarioByNome(@PathVariable String nome) {
        return funcionarioService.procurarFuncionarioPorNome(nome);
    }

    // Procurar Funcionario Pelo Id
    @GetMapping("/procurarFuncionarioPeloId/{id}")
    public FuncionarioDTO getFuncionarioById(@PathVariable Integer id) {
        return funcionarioService.procurarFuncionarioPorId(id);
    }

    // Deletar Cliente ou Excluir Conta
    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarFuncionario(@PathVariable Integer id) {
        funcionarioService.deletarFuncionario(id);
    }

}
