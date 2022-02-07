package com.fic.todo.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class OpenAPIConfig {

  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder().group("fic-todo-app").pathsToMatch("/**").build();
  }

  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info().title("Fic Todo App - REST API")
        .description("Manage daily tasks, and todo lists")
        .version("3.0.0")
        .termsOfService("My License")
        .license(new License().name("My standard license")));
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(false);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }

}
