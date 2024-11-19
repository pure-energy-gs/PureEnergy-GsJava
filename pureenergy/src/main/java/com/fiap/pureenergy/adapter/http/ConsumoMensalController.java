package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.mapper.ConsumoMensalDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.ConsumoMensalPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ConsumoMensalPutRequest;
import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import com.fiap.pureenergy.domain.service.ConsumoMensalServiceImpl;
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
@RequestMapping("/consumomensal")
public class ConsumoMensalController {

    @Autowired
    private ConsumoMensalServiceImpl consumoMensalService;

    @Autowired
    private ConsumoMensalDtoMapper consumoMensalDtoMapper;

    @Autowired
    private ConsumoMensalAssembler consumoMensalAssembler;

    @PostMapping
    public ResponseEntity<ConsumoMensalModel> cadastrarConsumoMensal(@RequestBody @Valid ConsumoMensalPostRequest request) {
        ConsumoMensalModel consumoMensalModel = consumoMensalDtoMapper.toModel(request);
        ConsumoMensalModel consumoMensalCadastrado = consumoMensalService.cadastrarConsumoMensal(consumoMensalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(consumoMensalCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<ConsumoMensalModel>>> listarConsumoMensal() {
        List<ConsumoMensalModel> consumosMensais = consumoMensalService.listarConsumoMensal();

        List<EntityModel<ConsumoMensalModel>> consumoMensalModels = consumosMensais.stream()
                .map(consumoMensalAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<ConsumoMensalModel>> response = CollectionModel.of(
                consumoMensalModels,
                linkTo(methodOn(ConsumoMensalController.class).listarConsumoMensal()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<ConsumoMensalModel> detalharConsumoMensal(@PathVariable String id) {
        ConsumoMensalModel consumoMensal = consumoMensalService.detalharConsumoMensal(id);
        return ResponseEntity.ok(consumoMensal);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ConsumoMensalModel> atualizarConsumoMensal(
            @PathVariable String id,
            @RequestBody @Valid ConsumoMensalPutRequest request) {
        ConsumoMensalModel consumoMensalExistente = consumoMensalService.detalharConsumoMensal(id);
        consumoMensalDtoMapper.updateModelFromPutRequest(request, consumoMensalExistente);
        ConsumoMensalModel consumoMensalAtualizado = consumoMensalService.atualizarConsumoMensal(id, consumoMensalExistente);
        return ResponseEntity.ok(consumoMensalAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsumoMensal(@PathVariable String id) {
        consumoMensalService.deletarConsumoMensal(id);
        return ResponseEntity.noContent().build();
    }



}
