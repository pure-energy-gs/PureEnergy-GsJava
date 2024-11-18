package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.request.ComodoPutRequest;
import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPatchRequest;
import com.fiap.pureenergy.domain.model.ComodoModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ComodoModelAssembler implements RepresentationModelAssembler<ComodoModel, EntityModel<ComodoModel>> {

    @Override
    public EntityModel<ComodoModel> toModel(ComodoModel comodo) {
        return EntityModel.of(comodo,
                linkTo(methodOn(ComodoController.class).detalharComodos(comodo.getIdComodo()))
                        .withSelfRel()
                        .withType("GET"),
                // Link para a listagem de usuários
                linkTo(methodOn(ComodoController.class).listarComodos())
                        .withRel("listarusuarios")
                        .withType("GET"),
                // Link para atualizar o recurso
                linkTo(methodOn(ComodoController.class).atualizarUsuario(comodo.getIdComodo(), new ComodoPutRequest()))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}
