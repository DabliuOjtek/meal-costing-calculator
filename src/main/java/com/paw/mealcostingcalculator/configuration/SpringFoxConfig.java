package com.paw.mealcostingcalculator.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    public static final String meal = "Meal";
    public static final String mealPlan = "Meal plan";
    public static final String product = "Product";
    public static final String productBatch = "Product batch";
    public static final String user = "User";


    @Bean
    public Docket get(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.paw.mealcostingcalculator.controller"))
                .build()
                .apiInfo(createApiInfo())
                .tags(new Tag(meal, ""),
                        new Tag(mealPlan, ""),
                        new Tag(product, ""),
                        new Tag(productBatch, ""),
                        new Tag(user, ""));
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Meals costing calculator API")
                .description("API to help calculate the price of created meals. User is able to add products with their quantity and price, create meals using the products and plan their daily consumption.")
                .version("1.0.0")
                .build();
    }
}
