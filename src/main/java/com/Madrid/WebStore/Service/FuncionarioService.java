package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.DTO.FuncionarioDTO;
import com.Madrid.WebStore.Repositorios.FuncionarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    FuncionarioRepositorio funcionarioRepositorio;

    ModelMapper modelMapper;

    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio, ModelMapper modelMapper) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.modelMapper = modelMapper;
    }

    // Cadastrar e Atualizar Funcionario
    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = FuncionarioDTO.fromEmployeeDTOtoEmployee(funcionarioDTO, modelMapper);
        funcionarioRepositorio.save(funcionario);
    }

    // Procurar Funcionário por Nome
    public List<FuncionarioDTO> procurarFuncionarioPorNome(String nome) {
        List<Funcionario> funcionarios = funcionarioRepositorio.findByNome(nome);
        List<FuncionarioDTO> funcionarioDTOs = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = FuncionarioDTO.fromEmployeeToEmployeeDTO(funcionario, modelMapper);
            funcionarioDTOs.add(funcionarioDTO);
        }

        return funcionarioDTOs;
    }

    // Procurar Funcionário por Id
    public FuncionarioDTO procurarFuncionarioPorId(Integer id) {
        Funcionario funcionario = funcionarioRepositorio.findById(id).orElseThrow();
        return FuncionarioDTO.fromEmployeeToEmployeeDTO(funcionario, modelMapper);
    }

    // Listar Todos os Funcionarios
    public List<FuncionarioDTO> listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepositorio.findAll();
        List<FuncionarioDTO> funcionarioDTOs = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = FuncionarioDTO.fromEmployeeToEmployeeDTO(funcionario, modelMapper);
            funcionarioDTOs.add(funcionarioDTO);
        }

        return funcionarioDTOs;
    }

}

