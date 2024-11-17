package com.fiap.pureenergy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoModel {

    private Long idEletrodomestico;
    private Long idComodo;
    private String nomeEletrodomestico;
    private Double potenciaWatts;
    private Double horasUsoDia;
    private String descricao;
}
