package com.ajsw.microdb;

import io.swagger.annotations.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/*
@SpringBootApplication
public class MicroDbApplication implements CommandLineRunner {
    private final PersonaRepository personaRepository;
    @Autowired
    public MicroDbApplication(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(MicroDbApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        personaRepository.save(new Persona("Persona1","ap1","432432"));
    }
}
*/
@Configuration
@SpringBootApplication
@EnableSwagger2
public class MicroDbApplication {
    @Bean
    public Docket schoolApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroDbApplication.class, args);
    }
}