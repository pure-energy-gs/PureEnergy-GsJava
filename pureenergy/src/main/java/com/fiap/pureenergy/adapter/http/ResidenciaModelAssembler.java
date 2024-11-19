package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPutRequest;
import com.fiap.pureenergy.domain.model.ResidenciaModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResidenciaModelAssembler implements RepresentationModelAssembler<ResidenciaModel, EntityModel<ResidenciaModel>> {

    @Override
    public EntityModel<ResidenciaModel> toModel(ResidenciaModel residencia) {
        return EntityModel.of(residencia,
                linkTo(methodOn(ResidenciaController.class).detalharResidencia(residencia.getIdResidencia()))
                        .withSelfRel()
                        .withType("GET"),
                linkTo(methodOn(ResidenciaController.class).listarResidencias())
                        .withRel("listarresidencias")
                        .withType("GET"),
                linkTo(methodOn(ResidenciaController.class).atualizarResidencia(residencia.getIdResidencia(), new ResidenciaPutRequest()))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}
