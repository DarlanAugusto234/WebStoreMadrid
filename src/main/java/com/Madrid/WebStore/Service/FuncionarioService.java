package com.Madrid.WebStore.Service;

import org.springframework.stereotype.Service;

import com.Madrid.WebStore.Classes.Funcionario;
import com.Madrid.WebStore.Repositorios.FuncionarioRepositorio;

import java.util.List;

@Service
public class FuncionarioService {

    FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    // Cadastrar e Atualizar Funcionario
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioRepositorio.save(funcionario);
    }

    // Procurar Funcionário por Nome
    public List<Funcionario> procurarFuncionarioPorNome(String nome) {
        return funcionarioRepositorio.findByNome(nome);
    }

    // Procurar Funcionário por Id
    public Funcionario procurarFuncionarioPorId(Integer id) {
        return funcionarioRepositorio.findById(id).orElse(null);
    }

    // Listar Todos os Funcionarios
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepositorio.findAll();
    }

}

