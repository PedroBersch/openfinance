package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumWeekDays {
    SEGUNDA_FEIRA("SEGUNDA-FEIRA"),
    TERCA_FEIRA("TERCA-FEIRA"),
    QUARTA_FEIRA("QUARTA-FEIRA"),
    QUINTA_FEIRA("QUINTA-FEIRA"),
    SEXTA_FEIRA("SEXTA-FEIRA"),
    SABADO("SABADO"),
    DOMINGO("DOMINGO");
    private final String val;
}
