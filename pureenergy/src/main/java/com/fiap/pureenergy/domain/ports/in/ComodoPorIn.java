package com.fiap.pureenergy.domain.ports.in;

public interface ComodoPorIn <Entrada, Saida>{

    Saida cadastrarComodo(Entrada entrada);

    Saida listarComodo();

    Saida atualizarComodo(String id, Entrada entrada);

    Saida deletarComodo(String id);

    Saida detalharComodo(String id);
}
