package com.thentrees.springdocopenapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "SpringDoc OpenAPI",
                version = "1.0",
                description = "SpringDoc OpenAPI Example",
                contact = @Contact(
                        name = "Thentrees",
                        email = "thientritran.dev@gmail.com",
                        url = "https://facebook.com/tltt289"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )

        )
)
public class SpringDocOpenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDocOpenApiApplication.class, args);
    }

}
