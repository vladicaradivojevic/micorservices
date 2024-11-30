package siv.cinema.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        locator.getRouteDefinitions().collectList().block().forEach(routeDefinition -> {
            String name = routeDefinition.getId();
            if (name.startsWith("ReactiveCompositeDiscoveryClient_")) {
            	name = name.split("ReactiveCompositeDiscoveryClient_")[1];
            }
            name = name.toLowerCase();
            GroupedOpenApi groupedOpenApi = GroupedOpenApi.builder()
                    .pathsToMatch("/" + name + "/**")
                    .group(name)
                    .build();

			groups.add(groupedOpenApi);
        });
        return groups;
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        		.components(new Components()
                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
                        		.type(SecurityScheme.Type.HTTP)
                        		.scheme("bearer")
                        		.bearerFormat("JWT")))
                        .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .info(new Info().title("Gateway API")
                        .version("1.0")
                        .description("Gateway API"));
    }
}
