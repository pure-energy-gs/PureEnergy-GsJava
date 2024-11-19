package com.fiap.pureenergy.domain.ports.in;

public interface ConsumoMensalPorIn <Entrada, Saida>{

    Saida cadastrarConsumoMensal(Entrada entrada);

    Saida listarConsumoMensal();

    Saida atualizarConsumoMensal(String id, Entrada entrada);

    Saida deletarConsumoMensal(String id);

    Saida detalharConsumoMensal(String id);
}
