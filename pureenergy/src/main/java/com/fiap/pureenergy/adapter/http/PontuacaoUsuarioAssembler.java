package com.fiap.pureenergy.adapter.http;


import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class PontuacaoUsuarioAssembler implements RepresentationModelAssembler<PontuacaoUsuarioModel, EntityModel<PontuacaoUsuarioModel>> {

    @Override
    public EntityModel<PontuacaoUsuarioModel> toModel(PontuacaoUsuarioModel pontuacaoUsuarioModel) {
        return EntityModel.of(pontuacaoUsuarioModel,
                linkTo(methodOn(PontucaoUsuarioController.class).listarUsuarios())
                        .withRel("listarusuarios")
                        .withType("GET")
        );
    }
}