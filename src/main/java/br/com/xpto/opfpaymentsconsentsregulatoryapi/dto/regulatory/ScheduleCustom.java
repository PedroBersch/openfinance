package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ScheduleCustom {
    @Valid
    @NotNull
    @Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
    private List<String> dates;
    @NotNull
    @Valid
    @Pattern(regexp = "[\\w\\W\\s]*")
    private String additionalInformation;
}
