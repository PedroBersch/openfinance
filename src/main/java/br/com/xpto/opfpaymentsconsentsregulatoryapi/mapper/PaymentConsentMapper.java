package br.com.xpto.opfpaymentsconsentsregulatoryapi.mapper;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.LinkSingle;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumAuthorisationStatusType;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.request.RequestCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseCreatePaymentConsentData;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class PaymentConsentMapper {
    private static final String URI_RESOURCE_GENERATOR = "https://api.banco.com.br/open-banking/api/v1/resource";

    public ResponseCreatePaymentConsent toPaymentConsentCreate(RequestCreatePaymentConsent consent) {
        var consentData = consent.getData();
        var localDateTime = LocalDateTime.now().toString();
        var consentId = String.format("urn:bancoex:%s", UUID.randomUUID());
        var paymentConsentData = ResponseCreatePaymentConsentData.builder()
            .consentId(consentId)
            .creationDateTime(localDateTime)
            .expirationDateTime(localDateTime)
            .statusUpdateDateTime(localDateTime)
            .status(EnumAuthorisationStatusType.AWAITING_AUTHORISATION)
            .loggedUser(consentData.getLoggedUser())
            .businessEntity(consentData.getBusinessEntity())
            .creditor(consentData.getCreditor())
            .payment(consentData.getPayment())
            .debtorAccount(consentData.getDebtorAccount())
            .build();
        return ResponseCreatePaymentConsent.builder()
            .data(paymentConsentData)
            .meta(new Meta(localDateTime))
            .self(new LinkSingle(URI_RESOURCE_GENERATOR))
            .build();

    }
}