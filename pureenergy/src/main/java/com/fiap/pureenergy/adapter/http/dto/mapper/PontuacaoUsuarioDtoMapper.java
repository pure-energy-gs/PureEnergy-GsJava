package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.response.PontuacaoUsuarioDetailResponse;
import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class PontuacaoUsuarioDtoMapper {

    public PontuacaoUsuarioDetailResponse toDetailResponse(PontuacaoUsuarioModel model) {
        if (model == null) {
            return null;
        }

        PontuacaoUsuarioDetailResponse response = new PontuacaoUsuarioDetailResponse();
        response.setIdPontuacao(model.getIdPontuacaoUsuario());
        response.setIdUsuario(model.getIdUsuario());
        response.setPontosTotais(model.getPontosTotais());
        response.setDataAtualizacao(model.getDataAtualizacao());
        return response;
    }

}
