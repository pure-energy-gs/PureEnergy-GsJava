package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class ConsumoMensalNotFoundException extends RuntimeException {

    private static final String DEFAULT_MENSAGEM = "Não existe uma consumo mensal com este ID";

    public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public ConsumoMensalNotFoundException   () {
        super(DEFAULT_MENSAGEM);
    }
}
