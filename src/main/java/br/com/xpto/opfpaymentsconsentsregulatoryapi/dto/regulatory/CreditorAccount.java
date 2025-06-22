package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumAccountPaymentsType;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentPersonType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreditorAccount {
    @Valid
    @NotNull
    @Pattern(regexp = "^[0-9]{8}$")
    private String ispb;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,4}$")
    @Valid
    private String issuer;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,20}$")
    @Valid
    private String number;
    @NotNull
    @Valid
    private EnumAccountPaymentsType accountType;
}
