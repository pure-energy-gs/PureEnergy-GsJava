package com.fiap.pureenergy.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidenciaModel {

    private Long idResidencia;
    private Long idUsuario;
    private String tipoResidencia;
    private Integer quantidadePessoas;
}
