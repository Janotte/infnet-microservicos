package br.edu.infnet.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/ordens/**").uri("http://localhost:8190"))
				.route(p -> p.path("/usuarios/**").uri("http://localhost:8191"))
				.route(p -> p.path("/pessoas/**").uri("http://localhost:8192"))
				.route(p -> p.path("/produtos/**").uri("http://localhost:8193"))
				.route(p -> p.path("/medidas/**").uri("http://localhost:8193"))
				.route(p -> p.path("/categorias/**").uri("http://localhost:8193"))
				.build();
	}

	@GetMapping("/fallback")
	public String fallback() {
		return "Por favor, tente mais tarde!";
	}

	private static Logger log = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando o Gateway da Aplicação...");
		SpringApplication.run(GatewayApplication.class, args);
		log.info("Gateway da Aplicação iniciado!");
	}

}
