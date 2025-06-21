package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumLocalInstrument {
    MANU("MANU"),
    DICT("DICT"),
    QRDN("QRDN"),
    QRES("QRES"),
    INIC("INIC");
    private final String value;
}
