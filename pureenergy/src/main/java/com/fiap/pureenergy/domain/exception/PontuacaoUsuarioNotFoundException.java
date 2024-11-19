package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class PontuacaoUsuarioNotFoundException extends RuntimeException {

    private static final String DEFAULT_MENSAGEM = "Não existe uma pontuação de usuário com este ID";

    public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public PontuacaoUsuarioNotFoundException() {
        super(DEFAULT_MENSAGEM);
    }

}
