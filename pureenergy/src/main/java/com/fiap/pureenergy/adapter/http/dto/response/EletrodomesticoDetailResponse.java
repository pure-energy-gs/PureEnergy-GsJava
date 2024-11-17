package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EletrodomesticoDetailResponse {

    @JsonProperty("id_eletrodomestico")
    private Long idEletrodomestico;

    @JsonProperty("id_comodo")
    private Long idComodo;

    @JsonProperty("nome_eletrodomestico")
    private String nomeEletrodomestico;

    @JsonProperty("potencia_watts")
    private Double potenciaWatts;

    @JsonProperty("horas_uso_dia")
    private Double horasUsoDia;

    @JsonProperty("descricao")
    private String descricao;

}
