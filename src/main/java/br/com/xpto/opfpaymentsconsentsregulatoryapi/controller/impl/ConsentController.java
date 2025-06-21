package br.com.xpto.opfpaymentsconsentsregulatoryapi.controller.impl;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.request.RequestCreatePaymentConsent;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.service.ConsentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v4")
@RequiredArgsConstructor
public class ConsentController {
    ConsentService consentService = new ConsentService();

    @PostMapping("/consents")
    public ResponseEntity<?> createConsent(
        @Validated @RequestBody final RequestCreatePaymentConsent request) {
        var response = consentService.createConsent(request);

        return ResponseEntity
            .created(URI.create(response.getSelf().getSelf()))
            .body(response);
    }
}
