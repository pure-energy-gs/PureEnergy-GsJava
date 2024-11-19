package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.domain.model.EnderecoModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EnderecoModelAssembler implements RepresentationModelAssembler<EnderecoModel, EntityModel<EnderecoModel>> {

    @Override
    public EntityModel<EnderecoModel> toModel(EnderecoModel endereco) {
        return EntityModel.of(endereco,
                linkTo(methodOn(EnderecoController.class).detalharEndereco(endereco.getIdEndereco()))
                        .withSelfRel()
                        .withType("GET"),
                linkTo(methodOn(EnderecoController.class).listarEnderecos())
                        .withRel("listarenderecos")
                        .withType("GET"),
                linkTo(methodOn(EnderecoController.class).atualizarEndereco(endereco.getIdEndereco(), null))
                        .withRel("atualizar")
                        .withType("PUT")
        );
    }
}
