package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.ComodoEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.ComodoModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ComodoMapper {

    // Mapear de ComodoEntity para ComodoModel
    public static ComodoModel toModel(ComodoEntity entity) {
        if (entity == null) {
            return null;
        }

        ComodoModel model = new ComodoModel();
        model.setIdComodo(entity.getIdComodo());
        model.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        model.setNomeComodo(entity.getNomeComodo());
        model.setDescricao(entity.getDescricao());

        model.setEletrodomesticos(entity.getEletrodomesticoEntities() != null
                ? entity.getEletrodomesticoEntities().stream()
                .map(EletrodomesticoMapper::toModel)
                .collect(Collectors.toList())
                : null);

        return model;
    }

    // Mapear de ComodoModel para ComodoEntity
    public static ComodoEntity toEntity(ComodoModel model) {
        if (model == null) {
            return null;
        }

        ComodoEntity entity = new ComodoEntity();
        entity.setIdComodo(model.getIdComodo());

        // Criar uma instância de UsuarioEntity apenas com o ID para estabelecer a relação
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(model.getIdUsuario());
        entity.setUsuario(usuarioEntity);

        entity.setNomeComodo(model.getNomeComodo());
        entity.setDescricao(model.getDescricao());

        entity.setEletrodomesticoEntities(model.getEletrodomesticos() != null
                ? model.getEletrodomesticos().stream()
                .map(EletrodomesticoMapper::toEntity)
                .collect(Collectors.toList())
                : null);

        return entity;
    }
}
