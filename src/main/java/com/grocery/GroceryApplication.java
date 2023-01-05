 package com.grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages= {"com.grocery.controller","com.grocery.entity","com.grocery.exception","com.grocery.dto","com.grocery.service","com.grocery.repository"})
@EnableSwagger2
public class GroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}
	
	@Bean
    public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.grocery.controller")).build().apiInfo(apiInfo());

   }


    private ApiInfo apiInfo() {
        
        return new ApiInfoBuilder().title("Grocery App")
                .description("Demo Session")
                .licenseUrl("abc@gmail.com").version("1.0").build();
    }

}