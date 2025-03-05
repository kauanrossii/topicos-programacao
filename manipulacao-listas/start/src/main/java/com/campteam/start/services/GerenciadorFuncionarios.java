package com.campteam.start.services;

import com.campteam.start.domain.Funcionario;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }

    public Funcionario buscarPorId(int id) throws BadRequestException {
        return funcionarios.stream()
                .filter(f -> f.id == id)
                .findFirst()
                .orElseThrow(BadRequestException::new);
    }

    public void remover(int funcionarioId) throws BadRequestException {
        var funcionario = buscarPorId(funcionarioId);
        funcionarios.remove(funcionario);
    }

    public void atualizarSalario(int id, double novoSalario) throws BadRequestException {
        Funcionario funcionario = buscarPorId(id);
        funcionario.salario = novoSalario;
    }
}
