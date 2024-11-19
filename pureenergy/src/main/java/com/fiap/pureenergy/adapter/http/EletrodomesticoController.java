package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.mapper.EletrodomesticoDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.EletrodomesticoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.EletrodomesticoPutRequest;
import com.fiap.pureenergy.domain.model.EletrodomesticoModel;
import com.fiap.pureenergy.domain.service.EletrodomesticoServiceImpl;
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
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoServiceImpl eletrodomesticoService;

    @Autowired
    private EletrodomesticoDtoMapper eletrodomesticoDtoMapper;

    @Autowired
    private EletrodomesticoModelAssembler eletrodomesticoAssembler;

    @PostMapping
    public ResponseEntity<EletrodomesticoModel> cadastrarEletrodomestico(@RequestBody @Valid EletrodomesticoPostRequest request) {
        EletrodomesticoModel eletrodomesticoModel = eletrodomesticoDtoMapper.toModel(request);
        EletrodomesticoModel eletrodomesticoCadastrado = eletrodomesticoService.cadastrarEletrodomestico(eletrodomesticoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomesticoCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<EletrodomesticoModel>>> listarEletrodomesticos() {
        List<EletrodomesticoModel> eletrodomesticos = eletrodomesticoService.listarEletrodomesticos();

        List<EntityModel<EletrodomesticoModel>> eletrodomesticoModels = eletrodomesticos.stream()
                .map(eletrodomesticoAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<EletrodomesticoModel>> response = CollectionModel.of(
                eletrodomesticoModels,
                linkTo(methodOn(EletrodomesticoController.class).listarEletrodomesticos()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<EletrodomesticoModel> detalharEletrodomestico(@PathVariable String id) {
        EletrodomesticoModel eletrodomestico = eletrodomesticoService.detalharEletrodomestico(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<EletrodomesticoModel> atualizarEletrodomestico(
            @PathVariable String id,
            @RequestBody @Valid EletrodomesticoPutRequest request) {
        EletrodomesticoModel eletrodomesticoExistente = eletrodomesticoService.detalharEletrodomestico(id);
        eletrodomesticoDtoMapper.updateModelFromPutRequest(request, eletrodomesticoExistente);
        EletrodomesticoModel eletrodomesticoAtualizado = eletrodomesticoService.atualizarEletrodomestico(id, eletrodomesticoExistente);
        return ResponseEntity.ok(eletrodomesticoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEletrodomestico(@PathVariable String id) {
        eletrodomesticoService.deletarEletrodomestico(id);
        return ResponseEntity.noContent().build();
    }
}
