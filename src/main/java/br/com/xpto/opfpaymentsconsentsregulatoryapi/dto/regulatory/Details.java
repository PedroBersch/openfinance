package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumLocalInstrument;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Details {
    @Valid
    @NotNull(message = "Local instrument cannot be null")
    private EnumLocalInstrument localInstrument;
    @Valid
    @Size(max = 5000, message = "QR code must not exceed 5000 characters")
    private String qrCode;

    @Valid
    @Size(max = 77, message = "Proxy must not exceed 77 characters")
    private String proxy;
    @Valid
    @NotNull(message = "Creditor account cannot be null")
    private CreditorAccount creditorAccount;
}
