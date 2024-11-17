package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.ComodoEntity;
import com.fiap.pureenergy.adapter.repository.entity.EletrodomesticoEntity;
import com.fiap.pureenergy.domain.model.EletrodomesticoModel;
import org.springframework.stereotype.Component;

@Component
public class EletrodomesticoMapper {

    // Mapear de EletrodomesticoEntity para EletrodomesticoModel
    public static EletrodomesticoModel toModel(EletrodomesticoEntity entity) {
        if (entity == null) {
            return null;
        }

        EletrodomesticoModel model = new EletrodomesticoModel();
        model.setIdEletrodomestico(entity.getIdEletrodomestico());
        model.setIdComodo(entity.getComodo() != null ? entity.getComodo().getIdComodo() : null);
        model.setNomeEletrodomestico(entity.getNomeEletrodomestico());
        model.setPotenciaWatts(entity.getPotenciaWatts());
        model.setHorasUsoDia(entity.getHorasUsoDia());
        model.setDescricao(entity.getDescricao());

        return model;
    }

    // Mapear de EletrodomesticoModel para EletrodomesticoEntity
    public static EletrodomesticoEntity toEntity(EletrodomesticoModel model) {
        if (model == null) {
            return null;
        }

        EletrodomesticoEntity entity = new EletrodomesticoEntity();
        entity.setIdEletrodomestico(model.getIdEletrodomestico());

        // Criar uma instância de ComodoEntity apenas com o ID para estabelecer a relação
        ComodoEntity comodoEntity = new ComodoEntity();
        comodoEntity.setIdComodo(model.getIdComodo());
        entity.setComodo(comodoEntity);

        entity.setNomeEletrodomestico(model.getNomeEletrodomestico());
        entity.setPotenciaWatts(model.getPotenciaWatts());
        entity.setHorasUsoDia(model.getHorasUsoDia());
        entity.setDescricao(model.getDescricao());

        return entity;
    }


}
