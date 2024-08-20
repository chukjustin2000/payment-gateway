package com.zenithbankgroup.paymentgateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 5:52 PM
 * @project paymentgateway
 */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Payment Gateway API")
                        .version("1.0")
                        .description("API for simulating a payment gateway middleware"));
    }
}
