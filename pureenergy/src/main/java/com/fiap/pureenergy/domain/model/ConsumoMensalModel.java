package com.fiap.pureenergy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoMensalModel {

    private Long idConsumoMensal;
    private Long idUsuario;
    private LocalDate mesReferencia;
    private Double consumoMensalKwh;
}
