package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String code;
    private String title;
    private String details;
}
