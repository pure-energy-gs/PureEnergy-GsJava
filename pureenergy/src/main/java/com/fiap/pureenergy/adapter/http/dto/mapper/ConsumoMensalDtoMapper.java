package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.request.ConsumoMensalPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ConsumoMensalPutRequest;
import com.fiap.pureenergy.adapter.http.dto.response.ConsumoMensalDetailResponse;
import com.fiap.pureenergy.adapter.http.dto.response.ConsumoMensalListResponse;
import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import org.springframework.stereotype.Component;

@Component
public class ConsumoMensalDtoMapper {

    // Mapeamento de ConsumoMensalPostRequest para ConsumoMensalModel
    public ConsumoMensalModel toModel(ConsumoMensalPostRequest request) {
        if (request == null) {
            return null;
        }

        ConsumoMensalModel model = new ConsumoMensalModel();
        model.setMesReferencia(request.getMesReferencia());
        model.setConsumoMensalKwh(request.getConsumoMensalKwh());
        model.setIdUsuario(request.getIdUsuario()); // Supondo que o modelo tem esse campo
        return model;
    }

    // Mapeamento de ConsumoMensalPutRequest para ConsumoMensalModel (Atualização Parcial)
    public void updateModelFromPutRequest(ConsumoMensalPutRequest request, ConsumoMensalModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getMesReferencia() != null) {
            model.setMesReferencia(request.getMesReferencia());
        }
        if (request.getConsumoMensalKwh() != null) {
            model.setConsumoMensalKwh(request.getConsumoMensalKwh());
        }
    }

    // Mapeamento de ConsumoMensalModel para ConsumoMensalDetailResponse
    public ConsumoMensalDetailResponse toDetailResponse(ConsumoMensalModel model) {
        if (model == null) {
            return null;
        }

        ConsumoMensalDetailResponse response = new ConsumoMensalDetailResponse();
        response.setIdConsumoMensal(model.getIdConsumoMensal());
        response.setMesReferencia(model.getMesReferencia());
        response.setConsumoMensalKwh(model.getConsumoMensalKwh());
        return response;
    }

    // Mapeamento de ConsumoMensalModel para ConsumoMensalListResponse
    public ConsumoMensalListResponse toListResponse(ConsumoMensalModel model) {
        if (model == null) {
            return null;
        }

        ConsumoMensalListResponse response = new ConsumoMensalListResponse();
        response.setIdConsumoMensal(model.getIdConsumoMensal());
        response.setMesReferencia(model.getMesReferencia());
        response.setConsumoMensalKwh(model.getConsumoMensalKwh());
        return response;
    }

}
