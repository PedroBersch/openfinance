package br.com.xpto.opfpaymentsconsentsregulatoryapi.exception;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.FieldErrorDetails;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.ErrorDTO;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumErrorCreateConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception.getBindingResult().getFieldErrors()
                .stream().map(error -> new FieldErrorDetails(error.getField(), error.getDefaultMessage(), error.getCode())).toList();
        var responseError = buildErrorResponse(errors, errors.getFirst().getJakartaCode());
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(responseError);
    }

    @ExceptionHandler(CreditorException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseError handleInvalidArgumentCreditorException(CreditorException exception) {
        return ResponseError.builder()
                .errors(List.of(new ErrorDTO(exception.getError().getCode(), exception.getError().getTitle(), String.format(exception.getError().getDetail(), exception.getMessage()))))
                .meta(new Meta(LocalDateTime.now().toString()))
                .build();
    }

    private ResponseError buildErrorResponse(List<FieldErrorDetails> errors, String code) {
        if ("Pattern".equals(code)) {
            return buildErrorParametroInvalid(errors);
        }
        return buildErrorParametroNaoInformado(errors);
    }

    private ResponseError buildErrorParametroNaoInformado(List<FieldErrorDetails> errors) {
        return ResponseError.builder()
                .errors(List.of(new ErrorDTO(EnumErrorCreateConsent.PARAMETRO_NAO_INFORMADO.name(),
                        EnumErrorCreateConsent.PARAMETRO_NAO_INFORMADO.getTitle(),
                        String.format(EnumErrorCreateConsent.PARAMETRO_NAO_INFORMADO.getDetail(), errors.getFirst().getField()))))
                .meta(new Meta(LocalDateTime.now().toString()))
                .build();
    }

    private ResponseError buildErrorParametroInvalid(List<FieldErrorDetails> errors) {
        return ResponseError.builder()
                .errors(List.of(new ErrorDTO(EnumErrorCreateConsent.PARAMETRO_INVALIDO.name(),
                        EnumErrorCreateConsent.PARAMETRO_INVALIDO.getTitle(),
                        String.format(EnumErrorCreateConsent.PARAMETRO_INVALIDO.getDetail(), errors.getFirst().getField()))))
                .meta(new Meta(LocalDateTime.now().toString()))
                .build();
    }
}
