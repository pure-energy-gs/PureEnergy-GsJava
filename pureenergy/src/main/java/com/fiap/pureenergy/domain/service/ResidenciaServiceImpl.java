package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.entity.ResidenciaEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.adapter.repository.mapper.ResidenciaMapper;
import com.fiap.pureenergy.domain.exception.ResidenciaNotFoudException;
import com.fiap.pureenergy.domain.model.ResidenciaModel;
import com.fiap.pureenergy.domain.ports.out.ResidenciaPotOut;
import com.fiap.pureenergy.domain.ports.out.UsuarioPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResidenciaServiceImpl implements ResidenciaService {

    @Autowired
    private ResidenciaMapper residenciaMapper;

    @Autowired
    private ResidenciaPotOut residenciaPotOut;

    @Autowired
    private UsuarioPortOut usuarioPortOut;


    @Override
    public ResidenciaModel cadastrarResidencia(ResidenciaModel residencia) {
        Assert.notNull(residencia.getIdUsuario(), "O ID do usuário não pode ser nulo");
        UsuarioEntity usuarioEntity = usuarioPortOut.findById(residencia.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ResidenciaEntity residenciaEntity = residenciaMapper.toEntity(residencia);
        residenciaEntity.setUsuario(usuarioEntity);
        ResidenciaEntity savedEntity = residenciaPotOut.save(residenciaEntity);
        return residenciaMapper.toModel(savedEntity);
    }

    @Override
    public List<ResidenciaModel> listarResidencias() {
        return residenciaPotOut.findAll().stream()
                .map(ResidenciaMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResidenciaModel> atualizarResidencia(Long id, ResidenciaModel residencia) {
        return residenciaPotOut.findById(id).map(entityExistente -> {
            var entityAtualizada = residenciaMapper.toEntity(residencia);
            entityAtualizada.setIdResidencia(id);

            residenciaPotOut.save(entityAtualizada);

            return residenciaMapper.toModel(entityAtualizada);
        });
    }

    @Override
    public boolean excluirResidencia(Long id) {
        if (residenciaPotOut.existsById(id)) {
            residenciaPotOut.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<ResidenciaModel> buscarResidencia(Long id) {
        return Optional.ofNullable(
                residenciaPotOut.findById(id)
                        .map(ResidenciaMapper::toModel)
                        .orElseThrow(ResidenciaNotFoudException::new)
        );
    }

    @Override
    public Optional<ResidenciaModel> detalharResidencia(Long id) {
        return Optional.ofNullable(
                residenciaPotOut.findById(id)
                        .map(ResidenciaMapper::toModel)
                        .orElseThrow(ResidenciaNotFoudException::new)
        );
    }
}
