package br.com.xpto.opfpaymentsconsentsregulatoryapi.service;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumErrorCreateConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentPersonType;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.request.RequestCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.exception.CreditorException;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.mapper.PaymentConsentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsentService {
    final PaymentConsentMapper mapper = new PaymentConsentMapper();

    public ResponseCreatePaymentConsent createConsent(RequestCreatePaymentConsent data) {
        validate(data);
        return mapper.toPaymentConsentCreate(data);
    }

    private void validate(RequestCreatePaymentConsent data) {
        validateCreditor(data);
    }

    private void validateCreditor(RequestCreatePaymentConsent data) {
        var creditor = data.getData().getCreditor();
        var personType = creditor.getPersonType();
        var cpfCnpj = creditor.getCpfCnpj();
        if (personType == EnumPaymentPersonType.PESSOA_JURIDICA && cpfCnpj.length() != 14) {
            throw new CreditorException(EnumErrorCreateConsent.PARAMETRO_INVALIDO.name(), EnumErrorCreateConsent.PARAMETRO_INVALIDO.getTitle(), EnumErrorCreateConsent.PARAMETRO_INVALIDO.getDetail());
        }
        if (personType == EnumPaymentPersonType.PESSOA_NATURAL && cpfCnpj.length() != 11) {
            throw new CreditorException(EnumErrorCreateConsent.PARAMETRO_INVALIDO.name(), EnumErrorCreateConsent.PARAMETRO_INVALIDO.getTitle(), EnumErrorCreateConsent.PARAMETRO_INVALIDO.getDetail());
        }
    }

}


