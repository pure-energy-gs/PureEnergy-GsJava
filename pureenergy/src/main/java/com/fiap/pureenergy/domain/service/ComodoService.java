package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.ComodoModel;
import com.fiap.pureenergy.domain.model.EnderecoModel;

import java.util.List;
import java.util.Optional;

public interface ComodoService {

    ComodoModel cadastrarComodo(ComodoModel comodo);

    List<ComodoModel> listarComodos();

    Optional<ComodoModel> atualizarComodo(Long id, ComodoModel comodo);

    boolean excluirComodo(Long id);

    Optional<ComodoModel> buscarComodo(Long id);

    Optional<ComodoModel> detalharComodo(Long id);
}
