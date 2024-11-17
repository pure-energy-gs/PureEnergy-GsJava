package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResidenciaListResponse {

    @JsonProperty("id_residencia")
    private Long idResidencia;

    @JsonProperty("tipo_residencia")
    private String tipoResidencia;
}
