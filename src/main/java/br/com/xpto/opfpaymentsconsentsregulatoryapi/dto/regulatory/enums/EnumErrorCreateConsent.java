package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumErrorCreateConsent {

    FORMA_PAGAMENTO_INVALIDA("Forma de pagamento inválida", "Forma de pagamento [%s] não suportada."),

    DATA_PAGAMENTO_INVALIDA("Data de pagamento inválida", "Data de pagamento inválida para a forma de pagamento selecionada."),

    DETALHE_PAGAMENTO_INVALIDO("Detalhe do pagamento inválido", "Parâmetro [%s] não obedece às regras de negócio."),

    PARAMETRO_NAO_INFORMADO("Parâmetro não informado", "Parâmetro [%s] obrigatório não informado."),

    PARAMETRO_INVALIDO("Parâmetro inválido", "Parâmetro [%s] não obedece as regras de formatação esperadas."),

    ERRO_IDEMPOTENCIA("Erro idempotência", "Conteúdo da mensagem (claim data) diverge do conteúdo associado a esta chave de idempotência (x-idempotency-key)."),

    NAO_INFORMADO("Não informado", "Não reportado/identificado pela instituição detentora de conta.");

    private final String title;
    private final String detail;

    public String getCode() {
        return name();
    }
}
