package com.fiap.pureenergy.adapter.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResidenciaPostRequest {

    @NotBlank(message = "O tipo da residência é obrigatório")
    @JsonProperty("tipo_residencia")
    private String tipoResidencia;

    @NotNull(message = "A quantidade de pessoas é obrigatória")
    @JsonProperty("quantidade_pessoas")
    private Integer quantidadePessoas;

    @NotNull(message = "O ID do usuário é obrigatório")
    @JsonProperty("id_usuario")
    private Long idUsuario;
}
