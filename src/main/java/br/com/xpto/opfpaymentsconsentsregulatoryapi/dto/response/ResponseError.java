package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.response;

import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.Meta;
import br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.ErrorDTO;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    List<ErrorDTO> errors;
    Meta meta;
}
