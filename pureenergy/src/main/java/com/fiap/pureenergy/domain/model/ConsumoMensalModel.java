package com.fiap.pureenergy.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoMensalModel {

    @JsonProperty("id_consumo_mensal")
    private Long idConsumoMensal;
    @JsonProperty("id_usuario")
    private Long idUsuario;
    @JsonProperty("mes_referencia")
    private LocalDate mesReferencia;
    @JsonProperty("consumo_mensal_kwh")
    private Double consumoMensalKwh;
}
