package com.fiap.pureenergy.adapter.http.dto.erros;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseErrors {

    public String campo;
    public String mensagem;

}
