package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.ConsumoMensalModel;

import java.util.List;

public interface ConsumoMensalService {

    ConsumoMensalModel cadastrarConsumoMensal(ConsumoMensalModel consumoMensal);

    List<ConsumoMensalModel> listarConsumoMensal();

    ConsumoMensalModel atualizarConsumoMensal(String id, ConsumoMensalModel consumoMensal);

    ConsumoMensalModel deletarConsumoMensal(String id);

    ConsumoMensalModel detalharConsumoMensal(String id);

}
