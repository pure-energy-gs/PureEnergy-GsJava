package com.fiap.pureenergy.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PontuacaoUsuarioModel {

    private Long idPontuacaoUsuario;
    private Long idUsuario;
    private Integer pontosTotais;
    private LocalDate dataAtualizacao;
}
