package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumAccountPaymentsType;
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

public class DebtorAccount {
    @Valid
    @NotNull
    @Pattern(regexp = "^[0-9]{8}$")
    private String ispb;
    @Pattern(regexp = "^[0-9]{1,4}$")
    @Valid
    private String issuer;
    @NotNull
    @Valid
    @Pattern(regexp = "^[0-9]{1,20}$")
    private String number;
    @Valid
    private EnumAccountPaymentsType accountType;
}
