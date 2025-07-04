package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums.EnumPaymentPersonType;
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

public class Identification {
    @Valid
    @NotNull(message = "Lorem")
    private EnumPaymentPersonType personType;
    @NotNull
    @Valid
    @Pattern(regexp = "^\\d{11}$|^\\d{14}$")
    private String cpfCnpj;
    @Valid
    @NotNull
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ,.@:&*+_<>()!?/\\\\$%\\d' -]+)$")
    private String name;
}
