package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCPF {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{11}$", message = "Valor do campo loggedUser.document.identification não seguem regras de negôcio")
    private String identification;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "Valor do campo loggedUser.document.rel não seguem regras de negôcio")
    private String rel;
}
