package br.edu.infnet.ordem.core.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {     
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        		"Ordens API", 
        		"Rest API de Ordens de Serviço para testes de microserviços com Spring Boot.", 
        		"V1.0", 
        		"Terms of service", 
        		new Contact("Sandro André Janotte", "www.usuario.infnet.edu.br", "sandro.janotte@al.infnet.edu.br"),
        		"License of API", "API license URL", 
        		Collections.emptyList());
        return apiInfo;
    }
}