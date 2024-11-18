package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.mapper.ComodoMapper;
import com.fiap.pureenergy.domain.exception.ComodoNotFoundException;
import com.fiap.pureenergy.domain.exception.EnderecoNotFoundException;
import com.fiap.pureenergy.domain.model.ComodoModel;
import com.fiap.pureenergy.domain.ports.out.ComodoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComodoServiceImlp implements ComodoService {

    @Autowired
    private ComodoMapper comodoMapper;

    @Autowired
    private ComodoPortOut comodoPortOut;


    @Override
    public ComodoModel cadastrarComodo(ComodoModel comodo) {
        var comodoEntity = comodoMapper.toEntity(comodo);
        var savedEntity = comodoPortOut.save(comodoEntity);
        return comodoMapper.toModel(savedEntity);
    }

    @Override
    public List<ComodoModel> listarComodos() {
        return comodoPortOut.findAll().stream()
                .map(ComodoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ComodoModel> atualizarComodo(Long id, ComodoModel comodo) {
        return comodoPortOut.findById(id)
                .map(existingEntity -> {
                    var updatedEntity = comodoMapper.toEntity(comodo);
                    var savedEntity = comodoPortOut.save(updatedEntity);
                    return comodoMapper.toModel(savedEntity);
                });
    }

    @Override
    public boolean excluirComodo(Long id) {
        if (comodoPortOut.existsById(id)) {
            comodoPortOut.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<ComodoModel> buscarComodo(Long id) {
        return Optional.of(
                comodoPortOut.findById(id)
                        .map(ComodoMapper::toModel)
                        .orElseThrow(ComodoNotFoundException::new)
        );
    }

    @Override
    public Optional<ComodoModel> detalharComodo(Long id) {
        return Optional.of(
                comodoPortOut.findById(id)
                        .map(ComodoMapper::toModel)
                        .orElseThrow(ComodoNotFoundException::new)
        );
    }

}
