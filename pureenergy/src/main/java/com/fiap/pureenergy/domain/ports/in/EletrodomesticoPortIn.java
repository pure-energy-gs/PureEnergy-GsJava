package com.fiap.pureenergy.domain.ports.in;

public interface EletrodomesticoPortIn <Entrada, Saida>{

    Saida cadastrarEletrodomestico(Entrada entrada);

    Saida listarEletrodomesticos();

    Saida atualizarEletrodomestico(String id, Entrada entrada);

    Saida deletarEletrodomestico(String id);

    Saida detalharEletrodomestico(String id);

}
