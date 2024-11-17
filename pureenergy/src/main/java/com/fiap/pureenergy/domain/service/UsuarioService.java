package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {


    UsuarioModel cadastrarUsuario(UsuarioModel usuario);

    List<UsuarioModel> listarUsuarios();

    Optional<UsuarioModel> atualizarUsuario(Long id, UsuarioModel usuario);

    boolean excluirUsuario(Long id);

    Optional<UsuarioModel> buscarUsuario(Long id);

    Optional<UsuarioModel> detalharUsuario(Long id);
}
