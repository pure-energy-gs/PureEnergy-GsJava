package com.fiap.pureenergy.domain.ports.in;

public interface ComodoPorIn <Entrada, Saida>{

    Saida cadastrarUsuario(Entrada entrada);

    Saida listarUsuarios();

    Saida atualizarUsuario(String id, Entrada entrada);

    Saida deletarUsuario(String id);

    Saida detalharUsuario(String id);
}
