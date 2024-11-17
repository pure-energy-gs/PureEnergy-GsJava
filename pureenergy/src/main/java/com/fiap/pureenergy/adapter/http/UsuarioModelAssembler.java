package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPatchRequest;
import com.fiap.pureenergy.domain.model.UsuarioModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<UsuarioModel, EntityModel<UsuarioModel>> {

    @Override
    public EntityModel<UsuarioModel> toModel(UsuarioModel usuario) {
        return EntityModel.of(usuario,
                // Link para o próprio recurso (self)
                linkTo(methodOn(UsuarioController.class).detalharUsuario(usuario.getIdUsuario()))
                        .withSelfRel()
                        .withType("GET"),
                // Link para a listagem de usuários
                linkTo(methodOn(UsuarioController.class).listarUsuarios())
                        .withRel("listarusuarios")
                        .withType("GET"),
                // Link para atualizar o recurso
                linkTo(methodOn(UsuarioController.class).atualizarUsuario(usuario.getIdUsuario(), new UsuarioPatchRequest()))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}


