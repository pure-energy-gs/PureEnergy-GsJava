package com.fiap.pureenergy.adapter.http;

import com.fiap.pureenergy.adapter.http.dto.mapper.EnderecoDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.EnderecoPostRequest;
import com.fiap.pureenergy.adapter.http.dto.request.EnderecoPutRequest;
import com.fiap.pureenergy.domain.model.EnderecoModel;
import com.fiap.pureenergy.domain.service.EnderecoServiceImpl;
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
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private EnderecoDtoMapper enderecoDtoMapper;

    @Autowired
    private EnderecoModelAssembler enderecoModelAssembler;

    @PostMapping
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody @Valid EnderecoPostRequest request) {
        EnderecoModel enderecoModel = enderecoDtoMapper.toModel(request);
        EnderecoModel enderecoCadastrado = enderecoService.cadastrarEndereco(enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<EnderecoModel>>> listarEnderecos() {
        List<EnderecoModel> enderecos = enderecoService.listarEnderecos();

        List<EntityModel<EnderecoModel>> enderecoModels = enderecos.stream()
                .map(enderecoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<EnderecoModel>> response = CollectionModel.of(
                enderecoModels,
                linkTo(methodOn(EnderecoController.class).listarEnderecos()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<EnderecoModel> detalharEndereco(@PathVariable Long id) {
        EnderecoModel endereco = enderecoService.detalharEndereco(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<EnderecoModel> atualizarEndereco(
            @PathVariable Long id,
            @RequestBody @Valid EnderecoPutRequest request) {
        EnderecoModel enderecoExistente = enderecoService.buscarEndereco(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        enderecoDtoMapper.updateModelFromPutRequest(request, enderecoExistente);

        EnderecoModel enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoExistente)
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar o endereço"));

        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable Long id) {
        boolean removido = enderecoService.excluirEndereco(id);
        if (!removido) {
            throw new RuntimeException("Endereço não encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
