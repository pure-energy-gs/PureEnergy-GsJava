package com.fiap.pureenergy.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComodoModel {

    public interface Resumo {}
    public interface Detalhes extends UsuarioModel.Resumo {}

    @JsonProperty("id_comodo")
    @JsonView(Resumo.class)
    private Long idComodo;
    @JsonView(Resumo.class)
    @JsonProperty("id_usuario")
    private Long idUsuario;
    @JsonProperty("nome_comodo")
    @JsonView(Resumo.class)
    private String nomeComodo;
    @JsonProperty("descricao")
    @JsonView(Resumo.class)
    private String descricao;

    @JsonProperty("eletrodomesticos")
    @JsonView(Detalhes.class)
    private List<EletrodomesticoModel> eletrodomesticos;
}
