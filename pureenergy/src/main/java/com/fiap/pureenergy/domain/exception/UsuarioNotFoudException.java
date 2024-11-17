package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class UsuarioNotFoudException extends RuntimeException {

    private static final String DEFAULT_MENSAGEM = "Não existe um usuario com este ID";
    // modificardor de acessos
    public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public UsuarioNotFoudException() {
        super(DEFAULT_MENSAGEM);
    }

}
