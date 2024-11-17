package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.ConsumoMensalEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import org.springframework.stereotype.Component;

@Component
public class ConsumoMensalMapper {

    // Mapear de ConsumoMensalEntity para ConsumoMensalModel
    public static ConsumoMensalModel toModel(ConsumoMensalEntity entity) {
        if (entity == null) {
            return null;
        }

        ConsumoMensalModel model = new ConsumoMensalModel();
        model.setIdConsumoMensal(entity.getIdConsumoMensal());
        model.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        model.setMesReferencia(entity.getMesReferencia());
        model.setConsumoMensalKwh(entity.getConsumoMensalKwh());

        return model;
    }

    // Mapear de ConsumoMensalModel para ConsumoMensalEntity
    public static ConsumoMensalEntity toEntity(ConsumoMensalModel model) {
        if (model == null) {
            return null;
        }

        ConsumoMensalEntity entity = new ConsumoMensalEntity();
        entity.setIdConsumoMensal(model.getIdConsumoMensal());

        // Criar uma instância de UsuarioEntity apenas com o ID para estabelecer a relação
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(model.getIdUsuario());
        entity.setUsuario(usuarioEntity);

        entity.setMesReferencia(model.getMesReferencia());
        entity.setConsumoMensalKwh(model.getConsumoMensalKwh());

        return entity;
    }
}
