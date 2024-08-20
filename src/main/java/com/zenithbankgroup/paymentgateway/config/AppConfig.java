package com.zenithbankgroup.paymentgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:48 PM
 * @project paymentgateway
 */

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}
