package org.test.wsd.testcommerce.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${spring.application.name}") String title) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title(title)
                        .description("testcommerce.com")
                        .version("0.0.1-SNAPSHOT"));
    }
}