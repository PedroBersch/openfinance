package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumPaymentType {
    PIX("PIX");
    private final String value;
}
