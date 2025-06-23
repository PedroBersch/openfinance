package br.com.xpto.opfpaymentsconsentsregulatoryapi.exception;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.ErrorDTO;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var responseError = ResponseError.builder()
                .errors(List.of(new ErrorDTO("PARAMETRO_INVALIDO", "Parâmetro inválido.", "Parâmetro [nome_campo] não obedece as regras de formatação esperadas.")))
                .meta(new Meta(LocalDateTime.now().toString()))
                .build();
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(responseError);
    }
}
