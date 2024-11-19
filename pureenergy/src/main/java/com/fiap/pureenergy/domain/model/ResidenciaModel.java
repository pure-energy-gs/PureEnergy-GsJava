package com.fiap.pureenergy.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidenciaModel {

    @JsonProperty("id_residencia")
    private Long idResidencia;
    @JsonProperty("id_usuario")
    private Long idUsuario;
    @JsonProperty("tipo_residencia")
    private String tipoResidencia;
    @JsonProperty("quantidade_pessoas")
    private Integer quantidadePessoas;
}
