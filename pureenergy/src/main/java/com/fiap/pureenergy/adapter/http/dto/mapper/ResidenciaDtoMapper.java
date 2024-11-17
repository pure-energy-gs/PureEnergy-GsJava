package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPutRequest;
import com.fiap.pureenergy.adapter.http.dto.response.ResidenciaDetailResponse;
import com.fiap.pureenergy.adapter.http.dto.response.ResidenciaListResponse;
import com.fiap.pureenergy.domain.model.ResidenciaModel;
import org.springframework.stereotype.Component;

@Component
public class ResidenciaDtoMapper {

    public ResidenciaModel toModel(ResidenciaPostRequest request) {
        if (request == null) {
            return null;
        }

        ResidenciaModel model = new ResidenciaModel();
        model.setTipoResidencia(request.getTipoResidencia());
        model.setQuantidadePessoas(request.getQuantidadePessoas());
        model.setIdUsuario(request.getIdUsuario()); // Supondo que o modelo possui esse campo
        return model;
    }


    public void updateModelFromPutRequest(ResidenciaPutRequest request, ResidenciaModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getTipoResidencia() != null) {
            model.setTipoResidencia(request.getTipoResidencia());
        }
        if (request.getQuantidadePessoas() != null) {
            model.setQuantidadePessoas(request.getQuantidadePessoas());
        }
    }

    public ResidenciaDetailResponse toDetailResponse(ResidenciaModel model) {
        if (model == null) {
            return null;
        }

        ResidenciaDetailResponse response = new ResidenciaDetailResponse();
        response.setIdResidencia(model.getIdResidencia());
        response.setTipoResidencia(model.getTipoResidencia());
        response.setQuantidadePessoas(model.getQuantidadePessoas());
        return response;
    }

    public ResidenciaListResponse toListResponse(ResidenciaModel model) {
        if (model == null) {
            return null;
        }

        ResidenciaListResponse response = new ResidenciaListResponse();
        response.setIdResidencia(model.getIdResidencia());
        response.setTipoResidencia(model.getTipoResidencia());
        return response;
    }
}
