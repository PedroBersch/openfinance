package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorDetails {
    private String field;
    private String message;
    private String jakartaCode;
}
