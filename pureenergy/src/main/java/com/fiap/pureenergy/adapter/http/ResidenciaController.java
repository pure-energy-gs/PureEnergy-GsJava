package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.mapper.ResidenciaDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.ResidenciaPutRequest;
import com.fiap.pureenergy.domain.model.ResidenciaModel;
import com.fiap.pureenergy.domain.service.ResidenciaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/residencia")
public class ResidenciaController {

    @Autowired
    private ResidenciaServiceImpl residenciaService;

    @Autowired
    private ResidenciaDtoMapper residenciaDtoMapper;

    @Autowired
    private ResidenciaModelAssembler residenciaModelAssembler;

    @PostMapping
    public ResponseEntity<ResidenciaModel> cadastrarResidenci(@RequestBody @Valid  ResidenciaPostRequest request) {
        if (request.getIdUsuario() == null) {
            throw new IllegalArgumentException("O ID do usuário não pode ser nulo");
        }
        ResidenciaModel residenciaModel = residenciaDtoMapper.toModel(request);
        ResidenciaModel residenciaCadastrada = residenciaService.cadastrarResidencia(residenciaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(residenciaCadastrada);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<ResidenciaModel>>> listarResidencias() {
        List<ResidenciaModel> residencias = residenciaService.listarResidencias();

        List<EntityModel<ResidenciaModel>> residenciaModels = residencias.stream()
                .map(residenciaModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<ResidenciaModel>> response = CollectionModel.of(
                residenciaModels,
                linkTo(methodOn(ResidenciaController.class).listarResidencias()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<ResidenciaModel> detalharResidencia(@PathVariable Long id) {
        ResidenciaModel residencia = residenciaService.detalharResidencia(id)
                .orElseThrow(() -> new RuntimeException("Residência não encontrada"));
        return ResponseEntity.ok(residencia);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ResidenciaModel> atualizarResidencia(
            @PathVariable Long id,
            @RequestBody @Valid ResidenciaPutRequest request) {
        ResidenciaModel residenciaExistente = residenciaService.buscarResidencia(id)
                .orElseThrow(() -> new RuntimeException("Residência não encontrada"));

        residenciaDtoMapper.updateModelFromPutRequest(request, residenciaExistente);

        ResidenciaModel residenciaAtualizada = residenciaService.atualizarResidencia(id, residenciaExistente)
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar a residência"));

        return ResponseEntity.ok(residenciaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirResidencia(@PathVariable Long id) {
        boolean removido = residenciaService.excluirResidencia(id);
        if (!removido) {
            throw new RuntimeException("Residência não encontrada");
        }
        return ResponseEntity.noContent().build();
    }
}
