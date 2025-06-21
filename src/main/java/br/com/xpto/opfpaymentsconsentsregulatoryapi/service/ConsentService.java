package br.com.xpto.opfpaymentsconsentsregulatoryapi.service;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.request.RequestCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response.ResponseCreatePaymentConsent;
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
        System.out.println("validado");
    }

}


