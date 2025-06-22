package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

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

public class DocumentCNPJ {
    @Valid
    @NotNull
    @Pattern(regexp = "^\\d{14}$",  message = "Valor do campo data.businessEntity.document.identification não seguem regras de negôcio")
    private String identification;
    @Valid
    @NotNull
    @Pattern(regexp = "^[A-Z]{4}$",  message = "Valor do campo data.businessEntity.document.rel não seguem regras de negôcio")
    private String rel;
}
