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
public class UsuarioModel {

    public interface Resumo {}
    public interface Detalhes extends Resumo {}

    @JsonProperty("id_usuario")
    @JsonView({Resumo.class, Detalhes.class})
    private Long idUsuario;

    @JsonProperty("nome")
    @JsonView({Resumo.class, Detalhes.class})
    private String nome;

    @JsonProperty("email")
    @JsonView({Resumo.class, Detalhes.class})
    private String email;

    @JsonProperty("senha")
    @JsonView({Detalhes.class, Resumo.class})
    private String senha;

    @JsonProperty("enderecos")
    @JsonView(Detalhes.class)
    private List<EnderecoModel> enderecos;

    @JsonProperty("residencias")
    @JsonView(Detalhes.class)
    private List<ResidenciaModel> residencias;

    @JsonProperty("comodos")
    @JsonView(Detalhes.class)
    private List<ComodoModel> comodos;

    @JsonProperty("consumos_mensais")
    @JsonView(Detalhes.class)
    private List<ConsumoMensalModel> consumosMensais;

    @JsonProperty("pontuacao_usuario")
    @JsonView(Detalhes.class)
    private PontuacaoUsuarioModel pontuacaoUsuario;

}
