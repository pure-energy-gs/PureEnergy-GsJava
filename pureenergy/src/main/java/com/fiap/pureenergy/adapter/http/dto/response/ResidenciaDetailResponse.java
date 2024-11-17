package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResidenciaDetailResponse {

    @JsonProperty("id_residencia")
    private Long idResidencia;

    @JsonProperty("tipo_residencia")
    private String tipoResidencia;

    @JsonProperty("quantidade_pessoas")
    private Integer quantidadePessoas;
}
