package com.fiap.pureenergy.adapter.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComodoPutRequest {

    @NotBlank(message = "O nome do cômodo é obrigatório")
    @JsonProperty("nome_comodo")
    private String nomeComodo;

    @JsonProperty("descricao")
    private String descricao;

}
