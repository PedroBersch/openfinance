package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.*;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumAuthorisationStatusType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ResponseCreatePaymentConsentData {
    @NotNull
    @Pattern(regexp = "^urn:[a-zA-Z0-9][a-zA-Z0-9\\-]{0,31}:[a-zA-Z0-9()+,\\-.:=@;$_!*'%\\/?#]+$")
    private String consentId;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String creationDateTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String expirationDateTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String statusUpdateDateTime;
    @NotNull
    private EnumAuthorisationStatusType status;
    @NotNull
    private LoggedUser loggedUser;
    private BusinessEntity businessEntity;
    @NotNull
    private Identification creditor;
    private DebtorAccount debtorAccount;
    @NotNull
    private ConsentPayment payment;
}
