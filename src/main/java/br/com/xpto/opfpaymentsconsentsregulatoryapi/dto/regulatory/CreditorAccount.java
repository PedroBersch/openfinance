package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentPersonType;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @NotNull
    @Pattern(regexp = "^[0-9]{8}$")
    private String ispb;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,4}$")
    private String issuer;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,20}$")
    private String number;
    @NotNull
    private EnumPaymentPersonType accountType;
}
