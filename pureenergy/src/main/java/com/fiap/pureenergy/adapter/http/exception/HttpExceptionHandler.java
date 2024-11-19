package com.fiap.pureenergy.adapter.http.exception;

import com.fiap.pureenergy.adapter.http.dto.erros.ResponseErrors;
import com.fiap.pureenergy.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> tratarErrosDeValidacaoFisica(MethodArgumentNotValidException exception){

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ResponseErrors> listaDeErro = new ArrayList<>();

        for (FieldError fieldError : fieldErrors){

            String campo = fieldError.getField();
            String mensagemDeErro = fieldError.getDefaultMessage();

            ResponseErrors responseErro = new ResponseErrors();
            responseErro.setCampo(campo);
            responseErro.setMensagem(mensagemDeErro);

            listaDeErro.add(responseErro);

        }

        return ResponseEntity.badRequest().body(listaDeErro);
    }

    @ExceptionHandler(UsuarioNotFoudException.class)
    public ResponseEntity<Object> tratarUsuarioNotFoundException(UsuarioNotFoudException usuarioNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(usuarioNotFoundException.getMessage());
        return ResponseEntity.status(usuarioNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<Object> tratarEnderecoNotFoundException(EnderecoNotFoundException enderecoNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(enderecoNotFoundException.getMessage());
        responseErro.campo = "cep";
        return ResponseEntity.status(enderecoNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(ResidenciaNotFoudException.class)
    public ResponseEntity<Object> tratarResidenciaNotFoundException(ResidenciaNotFoudException residenciaNotFoudException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(residenciaNotFoudException.getMessage());
        return ResponseEntity.status(residenciaNotFoudException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(ComodoNotFoundException.class)
    public ResponseEntity<Object> tratarComodoNotFoundException(ComodoNotFoundException comodoNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(comodoNotFoundException.getMessage());
        return ResponseEntity.status(comodoNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(ConsumoMensalNotFoundException.class)
    public ResponseEntity<Object> tratarConsumoMensalNotFoundException(ConsumoMensalNotFoundException consumoMensalNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(consumoMensalNotFoundException.getMessage());
        return ResponseEntity.status(consumoMensalNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(PontuacaoUsuarioNotFoundException.class)
    public ResponseEntity<Object> tratarPontuacaoUsuarioNotFoundException(PontuacaoUsuarioNotFoundException pontuacaoUsuarioNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(pontuacaoUsuarioNotFoundException.getMessage());
        return ResponseEntity.status(pontuacaoUsuarioNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

}
