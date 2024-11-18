package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class ResidenciaNotFoudException extends RuntimeException {

  private static final String DEFAULT_MENSAGEM = "Não existe uma residencia com este ID";

  public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

  public ResidenciaNotFoudException () {
    super(DEFAULT_MENSAGEM);
  }

}
