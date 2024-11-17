package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PontuacaoUsuarioDetailResponse {

    @JsonProperty("id_pontuacao")
    private Long idPontuacao;

    @JsonProperty("id_usuario")
    private Long idUsuario;

    @JsonProperty("pontos_totais")
    private Integer pontosTotais;

    @JsonProperty("data_atualizacao")
    private LocalDate dataAtualizacao;
}
