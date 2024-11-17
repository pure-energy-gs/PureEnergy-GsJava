package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.EnderecoModel;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    EnderecoModel cadastrarEndereco(EnderecoModel endereco);

    List<EnderecoModel> listarEnderecos();

    Optional<EnderecoModel> atualizarEndereco(Long id, EnderecoModel endereco);

    boolean excluirEndereco(Long id);

    Optional<EnderecoModel> buscarEndereco(Long id);

    Optional<EnderecoModel> detalharEndereco(Long id);

}
