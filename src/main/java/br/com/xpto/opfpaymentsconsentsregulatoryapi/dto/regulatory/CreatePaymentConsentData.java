package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

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

public class CreatePaymentConsentData {
    @NotNull
    @Valid
    private LoggedUser loggedUser;

    @Valid
    private BusinessEntity businessEntity;

    @NotNull
    @Valid
    private Identification creditor;

    @Valid
    private DebtorAccount debtorAccount;

    @NotNull
    @Valid
    private ConsentPayment payment;
}
