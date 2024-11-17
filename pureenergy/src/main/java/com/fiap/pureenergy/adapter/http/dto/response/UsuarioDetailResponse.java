package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDetailResponse {

    @JsonProperty("id_usuario")
    private Long idUsuario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("endereco")
    private List<EnderecoDetailResponse> enderecos;

    @JsonProperty("residencias")
    private List<ResidenciaDetailResponse> residencias;

    @JsonProperty("comodos")
    private List<ComodoDetailResponse> comodos;

    @JsonProperty("consumos_mensais")
    private List<ConsumoMensalDetailResponse> consumosMensais;

    @JsonProperty("pontuacao_usuario")
    private PontuacaoUsuarioDetailResponse pontuacaoUsuario;
}
