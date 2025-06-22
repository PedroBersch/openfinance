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
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LoggedUser {
    @Valid
    @NotNull
    private DocumentCPF document;
}
