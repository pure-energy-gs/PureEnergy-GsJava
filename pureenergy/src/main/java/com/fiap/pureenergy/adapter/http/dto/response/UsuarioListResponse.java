package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsuarioListResponse {

        @JsonProperty("id_usuario")
        private Long idUsuario;

        @JsonProperty("nome")
        private String nome;

        @JsonProperty("email")
        private String email;
}
