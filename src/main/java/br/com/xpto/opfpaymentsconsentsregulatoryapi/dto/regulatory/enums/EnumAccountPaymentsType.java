package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumAccountPaymentsType {
    CACC("CACC"),
    SVGS("SVGS"),
    TRAN("TRAN");
    private final String value;
}
