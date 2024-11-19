package com.fiap.pureenergy.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoModel {

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
