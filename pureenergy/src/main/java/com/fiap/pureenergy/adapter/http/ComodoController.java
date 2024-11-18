package com.fiap.pureenergy.adapter.http;


import com.fasterxml.jackson.annotation.JsonView;
import com.fiap.pureenergy.adapter.http.dto.mapper.ComodoDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.ComodoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ComodoPutRequest;
import com.fiap.pureenergy.domain.model.ComodoModel;
import com.fiap.pureenergy.domain.service.ComodoServiceImlp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/comodo")
public class ComodoController {

    @Autowired
    private ComodoServiceImlp comodoService;

    @Autowired
    private ComodoDtoMapper comodoDtoMapper;

    @Autowired
    private ComodoModelAssembler comodoModelAssembler;

    @PostMapping
    @JsonView(ComodoModel.Resumo.class)
    public ResponseEntity<ComodoModel> cadastrarComodo(@RequestBody @Valid ComodoPostRequest request) {
        ComodoModel comodoModel = comodoDtoMapper.toModel(request);
        ComodoModel comodoCadastrado = comodoService.cadastrarComodo(comodoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(comodoCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<ComodoModel>>> listarComodos() {
        List<ComodoModel> comodos = comodoService.listarComodos();

        List<EntityModel<ComodoModel>> comodoModels = comodos.stream()
                .map(comodoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<ComodoModel>> response = CollectionModel.of(
                comodoModels,
                linkTo(methodOn(ComodoController.class).listarComodos()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<ComodoModel> detalharComodos(@PathVariable Long id) {
        ComodoModel comodo = comodoService.detalharComodo(id)
                .orElseThrow(() -> new RuntimeException("Cômodo não encontrado"));
        return ResponseEntity.ok(comodo);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ComodoModel> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody @Valid ComodoPutRequest request) {
        ComodoModel comodoExistente = comodoService.buscarComodo(id)
                .orElseThrow(() -> new RuntimeException("Cômodo não encontrado"));

        comodoDtoMapper.updateModelFromPutRequest(request, comodoExistente);

        ComodoModel comodoAtualizado = comodoService.atualizarComodo(id, comodoExistente)
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar o cômodo"));

        return ResponseEntity.ok(comodoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirComodo(@PathVariable Long id) {
        boolean removido = comodoService.excluirComodo(id);
        if (!removido) {
            throw new RuntimeException("Cômodo não encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
