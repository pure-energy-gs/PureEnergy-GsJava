package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.ResidenciaModel;

import java.util.List;
import java.util.Optional;

public interface ResidenciaService {

    ResidenciaModel cadastrarResidencia(ResidenciaModel residencia);

    List<ResidenciaModel> listarResidencias();

    Optional<ResidenciaModel> atualizarResidencia(Long id, ResidenciaModel residencia);

    boolean excluirResidencia(Long id);

    Optional<ResidenciaModel> buscarResidencia(Long id);

    Optional<ResidenciaModel> detalharResidencia(Long id);
}
