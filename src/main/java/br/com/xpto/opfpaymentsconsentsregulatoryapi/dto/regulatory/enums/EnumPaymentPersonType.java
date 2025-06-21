package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumPaymentPersonType {
    PESSOA_NATURAL("PESSOA_NATURAL"),
    PESSOA_JURIDICA("PESSOA_JURIDICA");
    private final String value;

}
