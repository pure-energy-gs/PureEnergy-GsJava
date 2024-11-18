package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class ComodoNotFoundException extends RuntimeException {

    private static final String DEFAULT_MENSAGEM = "Não existe uma comodo com este ID";

    public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public ComodoNotFoundException  () {
        super(DEFAULT_MENSAGEM);
    }
}
