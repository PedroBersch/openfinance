package br.com.xpto.opfpaymentsconsentsregulatoryapi.exception;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.FieldErrorDetails;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.ErrorDTO;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumErrorCreateConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseError;
import org.apache.coyote.Response;
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
        List<FieldErrorDetails> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new FieldErrorDetails(error.getField(), error.getDefaultMessage())).toList();
        var responseError = ResponseError.builder()
                .errors(List.of(new ErrorDTO(EnumErrorCreateConsent.PARAMETRO_INVALIDO.getCode(),
                        EnumErrorCreateConsent.PARAMETRO_INVALIDO.getTitle(),
                        String.format(EnumErrorCreateConsent.PARAMETRO_INVALIDO.getDetail(), errors.getFirst().getField()))))
                .meta(new Meta(LocalDateTime.now().toString()))
                .build();
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(responseError);
    }
}
