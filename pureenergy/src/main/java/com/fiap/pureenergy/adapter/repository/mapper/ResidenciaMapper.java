package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.ResidenciaEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.ResidenciaModel;
import org.springframework.stereotype.Component;

@Component
public class ResidenciaMapper {

    // Mapear de ResidenciaEntity para ResidenciaModel
    public static ResidenciaModel toModel(ResidenciaEntity entity) {
        if (entity == null) {
            return null;
        }

        ResidenciaModel model = new ResidenciaModel();
        model.setIdResidencia(entity.getIdResidencia());
        model.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        model.setTipoResidencia(entity.getTipoResidencia());
        model.setQuantidadePessoas(entity.getQuantidadePessoas());

        return model;
    }

    // Mapear de ResidenciaModel para ResidenciaEntity
    public static ResidenciaEntity toEntity(ResidenciaModel model) {
        if (model == null) {
            return null;
        }

        ResidenciaEntity entity = new ResidenciaEntity();
        entity.setIdResidencia(model.getIdResidencia());

        // Criar uma instância de UsuarioEntity apenas com o ID para estabelecer a relação
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(model.getIdUsuario());
        entity.setUsuario(usuarioEntity);

        entity.setTipoResidencia(model.getTipoResidencia());
        entity.setQuantidadePessoas(model.getQuantidadePessoas());

        return entity;
    }
}
