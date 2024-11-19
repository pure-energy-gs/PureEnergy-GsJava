package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.mapper.PontuacaoUsuarioDtoMapper;
import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;
import com.fiap.pureenergy.domain.service.PontuacaoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pontuacao-usuario")
public class PontucaoUsuarioController {


    @Autowired
    private PontuacaoUsuarioServiceImpl pontuacaoUsuarioService;

    @Autowired
    private PontuacaoUsuarioAssembler pontuacaoUsuarioAssembler;

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<PontuacaoUsuarioModel>>> listarUsuarios() {
        List<PontuacaoUsuarioModel> pontuacoesUsuarios = pontuacaoUsuarioService.listarConsumoMensal();

        List<EntityModel<PontuacaoUsuarioModel>> pontuacaoUsuarioModels = pontuacoesUsuarios.stream()
                .map(pontuacaoUsuarioAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<PontuacaoUsuarioModel>> response = CollectionModel.of(
                pontuacaoUsuarioModels,
                linkTo(methodOn(PontucaoUsuarioController.class).listarUsuarios()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<PontuacaoUsuarioModel> detalharUsuario(@PathVariable String id) {
        PontuacaoUsuarioModel pontuacaoUsuario = pontuacaoUsuarioService.detalharConsumoMensal(id);
        return ResponseEntity.ok(pontuacaoUsuario);
    }
}
