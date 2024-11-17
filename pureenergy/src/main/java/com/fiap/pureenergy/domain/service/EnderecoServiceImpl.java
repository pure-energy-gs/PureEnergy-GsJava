package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.mapper.EnderecoMapper;
import com.fiap.pureenergy.domain.exception.EnderecoNotFoundException;
import com.fiap.pureenergy.domain.model.EnderecoModel;
import com.fiap.pureenergy.domain.ports.out.EnderecoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private EnderecoPortOut enderecoPortOut;


    @Override
    public EnderecoModel cadastrarEndereco(EnderecoModel endereco) {
        var enderecoEntity = enderecoMapper.toEntity(endereco);
        var savedEntity = enderecoPortOut.save(enderecoEntity);
        return enderecoMapper.toModel(savedEntity);
    }

    @Override
    public List<EnderecoModel> listarEnderecos() {
        return enderecoPortOut.findAll().stream()
                .map(EnderecoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EnderecoModel> atualizarEndereco(Long id, EnderecoModel endereco) {
        return enderecoPortOut.findById(id)
                .map(existingEntity -> {
                    var updatedEntity = enderecoMapper.toEntity(endereco);
                    var savedEntity = enderecoPortOut.save(updatedEntity);
                    return enderecoMapper.toModel(savedEntity);
                });
    }

    @Override
    public boolean excluirEndereco(Long id) {
        if (enderecoPortOut.existsById(id)) {
            enderecoPortOut.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<EnderecoModel> buscarEndereco(Long id) {
        return Optional.of(
                enderecoPortOut.findById(id)
                        .map(EnderecoMapper::toModel)
                        .orElseThrow(EnderecoNotFoundException::new)
        );
    }

    @Override
    public Optional<EnderecoModel> detalharEndereco(Long id) {
        return Optional.of(
                enderecoPortOut.findById(id)
                        .map(EnderecoMapper::toModel)
                        .orElseThrow(EnderecoNotFoundException::new)
        );
    }
}
