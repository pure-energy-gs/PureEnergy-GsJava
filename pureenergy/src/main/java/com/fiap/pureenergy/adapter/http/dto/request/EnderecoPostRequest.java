package com.fiap.pureenergy.adapter.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoPostRequest {

    @NotBlank(message = "O logradouro é obrigatório")
    @Size(max = 100, message = "O logradouro não pode ter mais que 100 caracteres")
    private String logradouro;

    @Size(max = 10, message = "O número não pode ter mais que 10 caracteres")
    private String numero;

    @Size(max = 50, message = "O complemento não pode ter mais que 50 caracteres")
    private String complemento;

    @Size(max = 50, message = "O bairro não pode ter mais que 50 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(max = 50, message = "A cidade não pode ter mais que 50 caracteres")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres")
    private String estado;

    @NotBlank(message = "O CEP é obrigatório")
    @Size(max = 10, message = "O CEP não pode ter mais que 10 caracteres")
    private String cep;

    @NotBlank(message = "O ID do usuário é obrigatório")
    @JsonProperty("id_usuario")
    private Long idUsuario;

}
