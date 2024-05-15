package com.Madrid.WebStore.DTO;

import com.Madrid.WebStore.Classes.Funcionario;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String cpf;
    private String emailFuncionario;
    private String senhaFuncionario;

    private static ModelMapper modelMapper = new ModelMapper();

    public FuncionarioDTO() {}

    // Getters e Setters

    public Funcionario converterParaFuncionario() {
        return modelMapper.map(this, Funcionario.class);
    }

    public static FuncionarioDTO converterDeFuncionario(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    // Método para converter lista de Funcionario para lista de FuncionarioDTO
    public static List<FuncionarioDTO> converterListaDeFuncionarios(List<Funcionario> funcionarios) {
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = converterDeFuncionario(funcionario);
            funcionariosDTO.add(funcionarioDTO);
        }

        return funcionariosDTO;

    }

}
