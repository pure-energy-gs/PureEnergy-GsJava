package com.fiap.pureenergy.adapter.http;

import com.fasterxml.jackson.annotation.JsonView;
import com.fiap.pureenergy.adapter.http.dto.mapper.UsuarioDtoMapper;
import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPatchRequest;
import com.fiap.pureenergy.adapter.http.dto.request.UsuarioPostRequest;
import com.fiap.pureenergy.domain.exception.UsuarioNotFoudException;
import com.fiap.pureenergy.domain.model.UsuarioModel;
import com.fiap.pureenergy.domain.service.UsuarioServiceImpl;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private UsuarioDtoMapper usuarioDtoMapper;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;


    @PostMapping
    @JsonView(UsuarioModel.Resumo.class)
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioPostRequest request) {
        UsuarioModel usuarioModel = usuarioDtoMapper.toModel(request);
        UsuarioModel usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<UsuarioModel>>> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.listarUsuarios();

        List<EntityModel<UsuarioModel>> usuarioModels = usuarios.stream()
                .map(usuarioModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<UsuarioModel>> response = CollectionModel.of(
                usuarioModels,
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    @JsonView(UsuarioModel.Detalhes.class)
    public ResponseEntity<UsuarioModel> detalharUsuario(@PathVariable Long id) {
        UsuarioModel usuario = usuarioService.detalharUsuario(id)
                .orElseThrow(UsuarioNotFoudException::new);
        return ResponseEntity.ok(usuario);
    }

    @PatchMapping("/{id}/atualizar")
    public ResponseEntity<UsuarioModel> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioPatchRequest request) {
        UsuarioModel usuarioExistente = usuarioService.buscarUsuario(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioDtoMapper.updateModelFromPatchRequest(request, usuarioExistente);

        UsuarioModel usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioExistente)
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar o usuário"));

        return ResponseEntity.ok(usuarioAtualizado);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        boolean removido = usuarioService.excluirUsuario(id);
        if (!removido) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return ResponseEntity.noContent().build();
    }

}
