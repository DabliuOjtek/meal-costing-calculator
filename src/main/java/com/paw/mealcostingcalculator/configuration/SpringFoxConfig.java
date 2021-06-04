package com.paw.mealcostingcalculator.configuration;

import com.paw.mealcostingcalculator.service.UserDetailsImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    public static final String meal = "Meal";
    public static final String mealPlan = "Meal plan";
    public static final String product = "Product";
    public static final String productBatch = "Product batch";
    public static final String user = "User";

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Meals costing calculator API")
                .description("API to help calculate the price of created meals. User is able to add products with their quantity and price, create meals using the products and plan their daily consumption.")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.paw.mealcostingcalculator.controller"))
                .build()
                .apiInfo(createApiInfo())
                .tags(new Tag(meal, ""),
                    new Tag(mealPlan, ""),
                    new Tag(product, ""),
                    new Tag(productBatch, ""),
                    new Tag(user, ""))
                .ignoredParameterTypes(UserDetailsImpl.class, RequestHeader.class)
                .securityContexts(singletonList(createContext()))
                .securitySchemes(singletonList(createSchema()));
    }

    private SecurityContext createContext() {
        return SecurityContext.builder()
                .securityReferences(createRef())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> createRef() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("apiKey", authorizationScopes));
    }

    private SecurityScheme createSchema() {
        return new ApiKey("apiKey", "Authorization", "header");
    }

}
