package com.fiap.pureenergy.domain.exception;

import org.springframework.http.HttpStatus;

public class EnderecoNotFoundException extends RuntimeException {

  private static final String DEFAULT_MENSAGEM = "Não existe um endereço com este ID";

  private static final String DEFAULT_MENSAGEM_CEP = "Não existe um endereço com este CEP";

  public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

  public EnderecoNotFoundException(String cep) {
        super(DEFAULT_MENSAGEM_CEP + cep);
    }
  public EnderecoNotFoundException() {
    super(DEFAULT_MENSAGEM);
  }
}
