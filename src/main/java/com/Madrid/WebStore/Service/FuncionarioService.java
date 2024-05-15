package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.DTO.FuncionarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Madrid.WebStore.Repositorios.FuncionarioRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    FuncionarioRepositorio funcionarioRepositorio;

    ModelMapper modelMapper;

    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    // Cadastrar e Atualizar Funcionario
    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        funcionarioRepositorio.save(funcionarioDTO.converterParaFuncionario());
    }

    // Procurar Funcionário por Nome
    public List<FuncionarioDTO> procurarFuncionarioPorNome(String nome) {
        List<Funcionario> funcionarios = funcionarioRepositorio.findByNomeContainingIgnoreCase(nome);
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            funcionariosDTO.add(modelMapper.map(funcionario, FuncionarioDTO.class));
        }

        return funcionariosDTO;
    }

    // Procurar Funcionário por Id
    public FuncionarioDTO procurarFuncionarioPorId(Integer id) {
        return funcionarioRepositorio.findById(id)
                .map(FuncionarioDTO::converterDeFuncionario)
                .orElse(null);
    }

    // Listar Todos os Funcionarios
    public List<FuncionarioDTO> listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepositorio.findAll();
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
            funcionariosDTO.add(funcionarioDTO);
        }

        return funcionariosDTO;
    }

    // Deletar Cliente pelo Id
    public void deletarFuncionario(Integer id){
        funcionarioRepositorio.deleteById(id);
    }

}

