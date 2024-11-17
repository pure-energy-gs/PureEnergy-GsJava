package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsumoMensalListResponse {

    @JsonProperty("id_consumo_mensal")
    private Long idConsumoMensal;

    @JsonProperty("mes_referencia")
    private LocalDate mesReferencia;

    @JsonProperty("consumo_mensal_kwh")
    private Double consumoMensalKwh;

}
