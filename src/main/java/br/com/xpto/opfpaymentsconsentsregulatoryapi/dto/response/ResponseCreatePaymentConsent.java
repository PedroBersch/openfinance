package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.LinkSingle;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCreatePaymentConsent {
    @NotNull
    private ResponseCreatePaymentConsentData data;
    @NotNull
    private LinkSingle self;
    @NotNull
    private Meta meta;

}
