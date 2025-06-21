package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private LoggedUser loggedUser;
    private BusinessEntity businessEntity;
    @NotNull
    private Identification creditor;
    private DebtorAccount debtorAccount;
    @NotNull
    private ConsentPayment payment;
}
