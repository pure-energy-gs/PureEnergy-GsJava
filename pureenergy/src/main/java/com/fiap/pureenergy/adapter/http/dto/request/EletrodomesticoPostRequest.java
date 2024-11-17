package com.fiap.pureenergy.adapter.http.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EletrodomesticoPostRequest {

    @NotNull(message = "O ID do cômodo é obrigatório")
    @JsonProperty("id_comodo")
    private Long idComodo;

    @NotBlank(message = "O nome do eletrodoméstico é obrigatório")
    @JsonProperty("nome_eletrodomestico")
    private String nomeEletrodomestico;

    @NotNull(message = "A potência em watts é obrigatória")
    @JsonProperty("potencia_watts")
    private Double potenciaWatts;

    @NotNull(message = "As horas de uso por dia são obrigatórias")
    @JsonProperty("horas_uso_dia")
    private Double horasUsoDia;

    @JsonProperty("descricao")
    private String descricao;
}