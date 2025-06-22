package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.request;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.CreatePaymentConsentData;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RequestCreatePaymentConsent {
    @NotNull
    @Valid
    CreatePaymentConsentData data;
}
