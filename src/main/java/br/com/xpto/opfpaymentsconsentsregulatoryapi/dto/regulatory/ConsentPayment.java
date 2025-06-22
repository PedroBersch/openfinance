package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumLocalInstrument;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ConsentPayment {
    @Valid
    @NotNull(message = "Payment type cannot be null")
    private EnumPaymentType type;
    @Valid
    private Schedule schedule;
    @Valid
    @Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$",
            message = "Date must be in YYYY-MM-DD format")
    private String date;
    @Valid
    @NotNull(message = "Currency cannot be null")
    @Pattern(regexp = "^[A-Z]{3}$",
            message = "Currency must be a 3-letter ISO code")
    private String currency;
    @Valid
    @Pattern(regexp = "^\\d{1,16}\\.\\d{2}$",
            message = "Amount must have up to 16 digits and 2 decimals")
    @NotNull(message = "Amount cannot be null")
    private String amount;
    @Valid
    @Pattern(regexp = "^\\d{7}$",
            message = "IBGE town code must be 7 digits")
    private String ibgeTownCode;
    @Valid
    @NotNull
    private Details details;
}