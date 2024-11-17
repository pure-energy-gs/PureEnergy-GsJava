package com.fiap.pureenergy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComodoModel {

    private Long idComodo;
    private Long idUsuario;
    private String nomeComodo;
    private String descricao;

    private List<EletrodomesticoModel> eletrodomesticos;
}
