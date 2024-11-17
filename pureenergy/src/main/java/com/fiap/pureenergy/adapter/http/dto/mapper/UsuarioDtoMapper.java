package com.fiap.pureenergy.adapter.http.dto.mapper;


import com.fiap.pureenergy.adapter.http.UsuarioController;
import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPatchRequest;
import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPostRequest;
import com.fiap.pureenergy.adapter.http.dto.response.UsuarioDetailResponse;
import com.fiap.pureenergy.adapter.http.dto.response.UsuarioListResponse;
import com.fiap.pureenergy.adapter.repository.mapper.PontuacaoUsuarioMapper;
import com.fiap.pureenergy.domain.model.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class UsuarioDtoMapper {

    private final EnderecoDtoMapper enderecoDtoMapper;

    private final ResidenciaDtoMapper residenciaMapper;

    private final ComodoDtoMapper comodoMapper;

    private final ConsumoMensalDtoMapper consumoMensalMapper;

    private final PontuacaoUsuarioDtoMapper pontuacaoUsuarioDtoMapper;


    public UsuarioModel toModel(UsuarioPostRequest request) {
        if (request == null) {
            return null;
        }
        UsuarioModel model = new UsuarioModel();
        model.setNome(request.getNome());
        model.setEmail(request.getEmail());
        model.setSenha(request.getSenha());
        return model;
    }


    public void updateModelFromPatchRequest(UsuarioPatchRequest request, UsuarioModel model) {
        if (request == null || model == null) {
            return;
        }
        if (request.getNome() != null) {
            model.setNome(request.getNome());
        }
        if (request.getEmail() != null) {
            model.setEmail(request.getEmail());
        }
        if (request.getSenha() != null) {
            model.setSenha(request.getSenha());
        }
    }

    // Mapeamento de UsuarioModel para UsuarioListResponse
    public UsuarioListResponse toListResponse(UsuarioModel model) {
        if (model == null) {
            return null;
        }
        UsuarioListResponse response = new UsuarioListResponse();
        response.setIdUsuario(model.getIdUsuario());
        response.setNome(model.getNome());
        response.setEmail(model.getEmail());

        return response;
    }


    public UsuarioDetailResponse toDetailResponse(UsuarioModel model) {
        if (model == null) {
            return null;
        }
        UsuarioDetailResponse response = new UsuarioDetailResponse();
        response.setIdUsuario(model.getIdUsuario());
        response.setNome(model.getNome());
        response.setEmail(model.getEmail());
        response.setEnderecos(model.getEnderecos() != null
                ? model.getEnderecos().stream()
                .map(enderecoDtoMapper::toDetailResponse)
                .collect(Collectors.toList())
                : null);
        response.setResidencias(model.getResidencias() != null
                ? model.getResidencias().stream()
                .map(residenciaMapper::toDetailResponse)
                .collect(Collectors.toList())
                : null);
        response.setComodos(model.getComodos() != null
                ? model.getComodos().stream()
                .map(comodoMapper::toDetailResponse)
                .collect(Collectors.toList())
                : null);
        response.setConsumosMensais(model.getConsumosMensais() != null
                ? model.getConsumosMensais().stream()
                .map(consumoMensalMapper::toDetailResponse)
                .collect(Collectors.toList())
                : null);
        response.setPontuacaoUsuario(model.getPontuacaoUsuario() != null
                ? pontuacaoUsuarioDtoMapper.toDetailResponse(model.getPontuacaoUsuario())
                : null);
        return response;
    }



}
