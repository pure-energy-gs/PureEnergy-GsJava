package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.PontuacaoUsuarioEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class PontuacaoUsuarioMapper {

    // Mapear de PontuacaoUsuarioEntity para PontuacaoUsuarioModel
    public static PontuacaoUsuarioModel toModel(PontuacaoUsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        PontuacaoUsuarioModel model = new PontuacaoUsuarioModel();
        model.setIdPontuacaoUsuario(entity.getIdPontuacao());
        model.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        model.setPontosTotais(entity.getPontosTotais());
        model.setDataAtualizacao(entity.getDataAtualizacao());

        return model;
    }

    // Mapear de PontuacaoUsuarioModel para PontuacaoUsuarioEntity
    public static PontuacaoUsuarioEntity toEntity(PontuacaoUsuarioModel model) {
        if (model == null) {
            return null;
        }

        PontuacaoUsuarioEntity entity = new PontuacaoUsuarioEntity();
        entity.setIdPontuacao(model.getIdPontuacaoUsuario());

        // Criar uma instância de UsuarioEntity apenas com o ID para estabelecer a relação
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(model.getIdUsuario());
        entity.setUsuario(usuarioEntity);

        entity.setPontosTotais(model.getPontosTotais());
        entity.setDataAtualizacao(model.getDataAtualizacao());

        return entity;
    }

}
