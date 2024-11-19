package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;

import java.util.List;

public interface PontuacaoUsuarioService {

    List<PontuacaoUsuarioModel> listarConsumoMensal();

    PontuacaoUsuarioModel detalharConsumoMensal(String id);
}
