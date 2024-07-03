package com.miguel.api_senna_connect_ar.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Poject Senna Connect AR API" ,version = "1.0",description = "Documentacion basica para la api ")
)
public class OpenApiConfig {
}
