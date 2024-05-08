package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.DTO.FuncionarioDTO;
import org.springframework.stereotype.Service;

import com.Madrid.WebStore.Repositorios.FuncionarioRepositorio;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    // Cadastrar e Atualizar Funcionario
    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        funcionarioRepositorio.save(funcionarioDTO.converterParaFuncionario());
    }

    // Procurar Funcionário por Nome
    public List<FuncionarioDTO> procurarFuncionarioPorNome(String nome) {
        return funcionarioRepositorio.findByNome(nome).stream()
                .map(FuncionarioDTO::converterDeFuncionario)
                .collect(Collectors.toList());
    }

    // Procurar Funcionário por Id
    public FuncionarioDTO procurarFuncionarioPorId(Integer id) {
        return funcionarioRepositorio.findById(id)
                .map(FuncionarioDTO::converterDeFuncionario)
                .orElse(null);
    }

    // Listar Todos os Funcionarios
    public List<FuncionarioDTO> listarTodosFuncionarios() {
        return funcionarioRepositorio.findAll().stream()
                .map(FuncionarioDTO::converterDeFuncionario)
                .collect(Collectors.toList());
    }

    // Deletar Cliente pelo Id
    public void deletarFuncionario(Integer id){
        funcionarioRepositorio.deleteById(id);
    }

}

