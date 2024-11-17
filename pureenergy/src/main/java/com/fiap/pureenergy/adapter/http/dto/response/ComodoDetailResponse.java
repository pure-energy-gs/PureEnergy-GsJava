package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ComodoDetailResponse {

    @JsonProperty("id_comodo")
    private Long idComodo;

    @JsonProperty("id_residencia")
    private String nomeComodo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("eletrodomesticos")
    private List<EletrodomesticoDetailResponse> eletrodomesticos;
}
