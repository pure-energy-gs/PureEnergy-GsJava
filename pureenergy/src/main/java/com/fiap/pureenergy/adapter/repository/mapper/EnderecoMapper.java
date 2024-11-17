package com.fiap.pureenergy.adapter.repository.mapper;

import com.fiap.pureenergy.adapter.repository.entity.EnderecoEntity;
import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.domain.model.EnderecoModel;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    // Mapear de EnderecoEntity para EnderecoModel
    public static EnderecoModel toModel(EnderecoEntity entity) {
        if (entity == null) {
            return null;
        }

        EnderecoModel model = new EnderecoModel();
        model.setIdEndereco(entity.getIdEndereco());
        model.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        model.setLogradouro(entity.getLogradouro());
        model.setNumero(entity.getNumero());
        model.setComplemento(entity.getComplemento());
        model.setBairro(entity.getBairro());
        model.setCidade(entity.getCidade());
        model.setEstado(entity.getEstado());
        model.setCep(entity.getCep());

        return model;
    }

    // Mapear de EnderecoModel para EnderecoEntity
    public static EnderecoEntity toEntity(EnderecoModel model) {
        if (model == null) {
            return null;
        }

        EnderecoEntity entity = new EnderecoEntity();
        entity.setIdEndereco(model.getIdEndereco());

        // Aqui você pode buscar o UsuarioEntity pelo ID ou criar um placeholder.
        // Por exemplo: UsuarioEntity usuario = usuarioRepository.findById(model.getIdUsuario()).orElse(null);
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(model.getIdUsuario());
        entity.setUsuario(usuarioEntity);

        entity.setLogradouro(model.getLogradouro());
        entity.setNumero(model.getNumero());
        entity.setComplemento(model.getComplemento());
        entity.setBairro(model.getBairro());
        entity.setCidade(model.getCidade());
        entity.setEstado(model.getEstado());
        entity.setCep(model.getCep());

        return entity;
    }
}
