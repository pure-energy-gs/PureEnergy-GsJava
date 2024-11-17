package com.fiap.pureenergy.adapter.http.dto.mapper;

import com.fiap.pureenergy.adapter.http.dto.request.EnderecoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.EnderecoPutRequest;
import com.fiap.pureenergy.adapter.http.dto.response.EnderecoDetailResponse;
import com.fiap.pureenergy.domain.model.EnderecoModel;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDtoMapper {

    public EnderecoModel toModel(EnderecoPostRequest request) {
        if (request == null) {
            return null;
        }

        EnderecoModel model = new EnderecoModel();
        model.setLogradouro(request.getLogradouro());
        model.setNumero(request.getNumero());
        model.setComplemento(request.getComplemento());
        model.setBairro(request.getBairro());
        model.setCidade(request.getCidade());
        model.setEstado(request.getEstado());
        model.setCep(request.getCep());
        model.setIdUsuario(request.getIdUsuario());
        return model;
    }

    public void updateModelFromPutRequest(EnderecoPutRequest request, EnderecoModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getLogradouro() != null) {
            model.setLogradouro(request.getLogradouro());
        }
        if (request.getNumero() != null) {
            model.setNumero(request.getNumero());
        }
        if (request.getComplemento() != null) {
            model.setComplemento(request.getComplemento());
        }
        if (request.getBairro() != null) {
            model.setBairro(request.getBairro());
        }
        if (request.getCidade() != null) {
            model.setCidade(request.getCidade());
        }
        if (request.getEstado() != null) {
            model.setEstado(request.getEstado());
        }
        if (request.getCep() != null) {
            model.setCep(request.getCep());
        }
    }

    public EnderecoDetailResponse toDetailResponse(EnderecoModel model) {
        if (model == null) {
            return null;
        }

        EnderecoDetailResponse response = new EnderecoDetailResponse();
        response.setIdEndereco(model.getIdEndereco());
        response.setLogradouro(model.getLogradouro());
        response.setNumero(model.getNumero());
        response.setComplemento(model.getComplemento());
        response.setBairro(model.getBairro());
        response.setCidade(model.getCidade());
        response.setEstado(model.getEstado());
        response.setCep(model.getCep());
        return response;
    }

}
