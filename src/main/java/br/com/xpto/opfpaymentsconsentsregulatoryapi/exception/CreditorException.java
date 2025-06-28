package br.com.xpto.opfpaymentsconsentsregulatoryapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditorException extends RuntimeException {
    public CreditorException(String message) {
        super(message);
    }
    private String code;
    private String title;
    private String detail;
}
