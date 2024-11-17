package com.fiap.pureenergy.adapter.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsumoMensalPostRequest {

    @NotNull(message = "O mês de referência é obrigatório")
    @JsonProperty("mes_referencia")
    private LocalDate mesReferencia;

    @NotNull(message = "O consumo mensal em kWh é obrigatório")
    @JsonProperty("consumo_mensal_kwh")
    private Double consumoMensalKwh;

    @NotNull(message = "O ID do usuário é obrigatório")
    @JsonProperty("id_usuario")
    private Long idUsuario; // Para vincular o consumo ao usuário

}
