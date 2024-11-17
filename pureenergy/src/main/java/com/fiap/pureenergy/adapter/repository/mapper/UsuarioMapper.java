package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioMapper {




    public static UsuarioModel toModel(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        UsuarioModel model = new UsuarioModel();
        model.setIdUsuario(entity.getIdUsuario());
        model.setNome(entity.getNome());
        model.setEmail(entity.getEmail());
        model.setSenha(entity.getSenha());

        model.setEnderecos(entity.getEnderecoEntities() != null
                ? entity.getEnderecoEntities().stream()
                .map(EnderecoMapper::toModel)
                .collect(Collectors.toList())
                : null);

        model.setResidencias(entity.getResidenciaEntities() != null
                ? entity.getResidenciaEntities().stream()
                .map(ResidenciaMapper::toModel)
                .collect(Collectors.toList())
                : null);

        model.setComodos(entity.getComodoEntities() != null
                ? entity.getComodoEntities().stream()
                .map(ComodoMapper::toModel)
                .collect(Collectors.toList())
                : null);

        model.setConsumosMensais(entity.getConsumosMensais() != null
                ? entity.getConsumosMensais().stream()
                .map(ConsumoMensalMapper::toModel)
                .collect(Collectors.toList())
                : null);

        model.setPontuacaoUsuario(entity.getPontuacaoUsuarioEntity() != null
                ? PontuacaoUsuarioMapper.toModel(entity.getPontuacaoUsuarioEntity())
                : null);

        return model;
    }


    public static UsuarioEntity toEntity(UsuarioModel model) {
        if (model == null) {
            return null;
        }

        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(model.getIdUsuario());
        entity.setNome(model.getNome());
        entity.setEmail(model.getEmail());
        entity.setSenha(model.getSenha());

        entity.setEnderecoEntities(model.getEnderecos() != null
                ? model.getEnderecos().stream()
                .map(EnderecoMapper::toEntity)
                .collect(Collectors.toList())
                : null);

        entity.setResidenciaEntities(model.getResidencias() != null
                ? model.getResidencias().stream()
                .map(ResidenciaMapper::toEntity)
                .collect(Collectors.toList())
                : null);

        entity.setComodoEntities(model.getComodos() != null
                ? model.getComodos().stream()
                .map(ComodoMapper::toEntity)
                .collect(Collectors.toList())
                : null);

        entity.setConsumosMensais(model.getConsumosMensais() != null
                ? model.getConsumosMensais().stream()
                .map(ConsumoMensalMapper::toEntity)
                .collect(Collectors.toList())
                : null);

        entity.setPontuacaoUsuarioEntity(model.getPontuacaoUsuario() != null
                ? PontuacaoUsuarioMapper.toEntity(model.getPontuacaoUsuario())
                : null);

        return entity;
    }
}

