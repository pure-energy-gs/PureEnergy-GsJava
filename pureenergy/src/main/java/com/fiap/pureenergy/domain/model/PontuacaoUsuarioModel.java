package com.fiap.pureenergy.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PontuacaoUsuarioModel {

    @JsonProperty("id_pontuacao_usuario")
    private Long idPontuacaoUsuario;
    @JsonProperty("id_usuario")
    private Long idUsuario;
    @JsonProperty("pontos_totais")
    private Integer pontosTotais;
    @JsonProperty("data_atualizacao")
    private LocalDate dataAtualizacao;
}
