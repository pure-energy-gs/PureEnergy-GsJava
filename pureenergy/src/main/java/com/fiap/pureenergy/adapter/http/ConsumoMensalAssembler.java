package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.request.ConsumoMensalPutRequest;
import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ConsumoMensalAssembler implements RepresentationModelAssembler<ConsumoMensalModel, EntityModel<ConsumoMensalModel>> {

    @Override
    public EntityModel<ConsumoMensalModel> toModel(ConsumoMensalModel consumoMensal) {
        return EntityModel.of(consumoMensal,
                linkTo(methodOn(ConsumoMensalController.class)
                        .detalharConsumoMensal(String.valueOf(consumoMensal.getIdConsumoMensal())))
                        .withSelfRel()
                        .withType("GET"),
                linkTo(methodOn(ConsumoMensalController.class)
                        .listarConsumoMensal())
                        .withRel("listarconsumomensal")
                        .withType("GET"),
                linkTo(methodOn(ConsumoMensalController.class)
                        .atualizarConsumoMensal(String.valueOf(consumoMensal.getIdConsumoMensal()), new ConsumoMensalPutRequest()))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}
