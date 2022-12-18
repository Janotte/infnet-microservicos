package br.edu.infnet.usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
public class UsuarioApplication {

	private static Logger log = LoggerFactory.getLogger(UsuarioApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando a API de Cadastro de Usuários...");
		SpringApplication.run(UsuarioApplication.class, args);
		log.info("API de Cadastro de Usuários iniciada, pronta para receber requisições!");
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
