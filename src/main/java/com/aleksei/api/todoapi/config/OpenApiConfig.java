package com.aleksei.api.todoapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "To-Do API",
                version = "1.0",
                description = "API for planning and managing activities"
        )
)
public class OpenApiConfig {
}
