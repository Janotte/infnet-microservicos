package br.edu.infnet.pessoa;

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

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class PessoaApplication {

	private static Logger log = LoggerFactory.getLogger(PessoaApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando a API de Cadastro de Pessoas...");
		SpringApplication.run(PessoaApplication.class, args);
		log.info("API de Cadastro de Pessoas iniciada, pronta para receber requisições!");
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
