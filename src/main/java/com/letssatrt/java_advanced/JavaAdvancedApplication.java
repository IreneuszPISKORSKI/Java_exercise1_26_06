package com.letssatrt.java_advanced;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        description = "Hello in Irek's app",
        title = "OpenApi - Irek"
))
//@EnableSwagger2
public class JavaAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaAdvancedApplication.class, args);
    }

}
