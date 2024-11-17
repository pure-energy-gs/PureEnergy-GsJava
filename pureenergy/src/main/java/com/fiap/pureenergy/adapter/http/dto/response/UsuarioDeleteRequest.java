package com.fiap.pureenergy.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDeleteRequest {

    @NotNull(message = "O ID do usuário é obrigatório")
    @JsonProperty("id_usuario")
    private Long idUsuario;

}
