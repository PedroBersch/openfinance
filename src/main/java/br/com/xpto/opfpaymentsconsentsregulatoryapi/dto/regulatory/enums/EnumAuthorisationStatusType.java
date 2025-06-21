package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumAuthorisationStatusType {
    AWAITING_AUTHORISATION("AWAITING_AUTHORISATION", "Aguardando autorização"),
    PARTIALLY_ACCEPTED("PARTIALLY_ACCEPTED", "Aguardando múltiplas alçadas"),
    AUTHORISED("AUTHORISED", "Autorizado"),
    REJECTED("REJECTED", "Rejeitado"),
    CONSUMED("CONSUMED", "Consumido");

    private final String value;
    private final String description;
}
