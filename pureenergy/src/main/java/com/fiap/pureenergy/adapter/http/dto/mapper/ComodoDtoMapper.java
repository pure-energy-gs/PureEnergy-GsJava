package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.request.ComodoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ComodoPutRequest;
import com.fiap.pureenergy.adapter.http.dto.response.ComodoDetailResponse;
import com.fiap.pureenergy.domain.model.ComodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ComodoDtoMapper {

    @Autowired
    private EletrodomesticoDtoMapper eletrodomesticoDtoMapper;

    // Mapeamento de ComodoPostRequest para ComodoModel
    public ComodoModel toModel(ComodoPostRequest request) {
        if (request == null) {
            return null;
        }

        ComodoModel model = new ComodoModel();
        model.setNomeComodo(request.getNomeComodo());
        model.setDescricao(request.getDescricao());
        model.setIdUsuario(request.getIdUsuario()); // Assumindo que o modelo tem o campo idUsuario
        return model;
    }

    // Mapeamento de ComodoPutRequest para ComodoModel (Atualização Parcial)
    public void updateModelFromPutRequest(ComodoPutRequest request, ComodoModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getNomeComodo() != null) {
            model.setNomeComodo(request.getNomeComodo());
        }
        if (request.getDescricao() != null) {
            model.setDescricao(request.getDescricao());
        }
    }

    // Mapeamento de ComodoModel para ComodoDetailResponse
    public ComodoDetailResponse toDetailResponse(ComodoModel model) {
        if (model == null) {
            return null;
        }

        ComodoDetailResponse response = new ComodoDetailResponse();
        response.setIdComodo(model.getIdComodo());
        response.setNomeComodo(model.getNomeComodo());
        response.setDescricao(model.getDescricao());
        response.setEletrodomesticos(model.getEletrodomesticos() != null
                ? model.getEletrodomesticos().stream()
                .map(eletrodomesticoDtoMapper::toDetailResponse) // Assumindo que há um EletrodomesticoMapper
                .collect(Collectors.toList())
                : null);
        return response;
    }
}
