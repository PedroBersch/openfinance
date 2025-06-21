package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumLocalInstrument;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentType;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @NotNull(message = "Payment type cannot be null")
    private EnumPaymentType type;

    private Schedule schedule;

    @Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$",
        message = "Date must be in YYYY-MM-DD format")
    private String date;

    @NotNull(message = "Currency cannot be null")
    @Pattern(regexp = "^[A-Z]{3}$",
        message = "Currency must be a 3-letter ISO code")
    private String currency;

    @Pattern(regexp = "^\\d{1,16}\\.\\d{2}$",
        message = "Amount must have up to 16 digits and 2 decimals")
    @NotNull(message = "Amount cannot be null")
    private String amount;

    @Pattern(regexp = "^\\d{7}$",
        message = "IBGE town code must be 7 digits")
    private String ibgeTownCode;

    @NotNull(message = "Local instrument cannot be null")
    private EnumLocalInstrument localInstrument;

    @Size(max = 5000, message = "QR code must not exceed 5000 characters")
    private String qrCode;

    @Size(max = 77, message = "Proxy must not exceed 77 characters")
    private String proxy;

    @NotNull(message = "Creditor account cannot be null")
    private CreditorAccount creditorAccount;
}