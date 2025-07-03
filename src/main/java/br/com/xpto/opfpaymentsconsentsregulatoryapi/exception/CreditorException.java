package br.com.xpto.opfpaymentsconsentsregulatoryapi.exception;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumErrorCreateConsent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class CreditorException extends RuntimeException {
    private final EnumErrorCreateConsent error;
    public CreditorException(EnumErrorCreateConsent error, String message) {
        super(message);
        this.error = error;
    }
}
