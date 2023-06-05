package com.ejmc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfiguration{
	@Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Spring Boot API Documentation")
        		.description("서버 API에 대한 연동 문서입니다")
                .version("1.0.0");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}