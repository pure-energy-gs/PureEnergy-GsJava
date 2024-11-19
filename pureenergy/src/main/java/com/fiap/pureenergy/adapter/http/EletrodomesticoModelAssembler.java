package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.request.EletrodomesticoPutRequest;
import com.fiap.pureenergy.domain.model.EletrodomesticoModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EletrodomesticoModelAssembler implements RepresentationModelAssembler<EletrodomesticoModel, EntityModel<EletrodomesticoModel>> {

    @Override
    public EntityModel<EletrodomesticoModel> toModel(EletrodomesticoModel eletrodomestico) {
        return EntityModel.of(eletrodomestico,
                linkTo(methodOn(EletrodomesticoController.class)
                        .detalharEletrodomestico(String.valueOf(eletrodomestico.getIdEletrodomestico())))
                        .withSelfRel()
                        .withType("GET"),

                linkTo(methodOn(EletrodomesticoController.class)
                        .listarEletrodomesticos())
                        .withRel("listareletrodomesticos")
                        .withType("GET"),

                linkTo(methodOn(EletrodomesticoController.class)
                        .atualizarEletrodomestico(String.valueOf(eletrodomestico.getIdEletrodomestico()), new EletrodomesticoPutRequest()))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}