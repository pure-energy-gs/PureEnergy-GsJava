package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.request.EletrodomesticoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.EletrodomesticoPutRequest;
import com.fiap.pureenergy.adapter.http.dto.response.EletrodomesticoDetailResponse;
import com.fiap.pureenergy.domain.model.EletrodomesticoModel;
import org.springframework.stereotype.Component;

@Component
public class EletrodomesticoDtoMapper {

    // Mapeamento de EletrodomesticoPostRequest para EletrodomesticoModel
    public EletrodomesticoModel toModel(EletrodomesticoPostRequest request) {
        if (request == null) {
            return null;
        }

        EletrodomesticoModel model = new EletrodomesticoModel();
        model.setIdComodo(request.getIdComodo());
        model.setNomeEletrodomestico(request.getNomeEletrodomestico());
        model.setPotenciaWatts(request.getPotenciaWatts());
        model.setHorasUsoDia(request.getHorasUsoDia());
        model.setDescricao(request.getDescricao());
        return model;
    }

    // Mapeamento de EletrodomesticoPutRequest para EletrodomesticoModel (Atualização Parcial)
    public void updateModelFromPutRequest(EletrodomesticoPutRequest request, EletrodomesticoModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getNomeEletrodomestico() != null) {
            model.setNomeEletrodomestico(request.getNomeEletrodomestico());
        }
        if (request.getPotenciaWatts() != null) {
            model.setPotenciaWatts(request.getPotenciaWatts());
        }
        if (request.getHorasUsoDia() != null) {
            model.setHorasUsoDia(request.getHorasUsoDia());
        }
        if (request.getDescricao() != null) {
            model.setDescricao(request.getDescricao());
        }
    }

    // Mapeamento de EletrodomesticoModel para EletrodomesticoDetailResponse
    public EletrodomesticoDetailResponse toDetailResponse(EletrodomesticoModel model) {
        if (model == null) {
            return null;
        }

        EletrodomesticoDetailResponse response = new EletrodomesticoDetailResponse();
        response.setIdEletrodomestico(model.getIdEletrodomestico());
        response.setIdComodo(model.getIdComodo());
        response.setNomeEletrodomestico(model.getNomeEletrodomestico());
        response.setPotenciaWatts(model.getPotenciaWatts());
        response.setHorasUsoDia(model.getHorasUsoDia());
        response.setDescricao(model.getDescricao());
        return response;
    }

}
