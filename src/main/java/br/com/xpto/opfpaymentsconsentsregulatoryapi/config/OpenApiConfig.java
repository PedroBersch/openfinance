package br.com.xpto.opfpaymentsconsentsregulatoryapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Payment Consents API")
                .version("4.0.0")
                .description("API regulatória de iniciação de pagamentos")
            );
    }
}