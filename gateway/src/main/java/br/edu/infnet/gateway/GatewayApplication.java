package br.edu.infnet.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/ordens/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8190"))
				.route(p -> p.path("/usuarios/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8191"))
				.route(p -> p.path("/pessoas/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8192"))
				.route(p -> p.path("/produtos/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8193"))
				.route(p -> p.path("/medidas/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8193"))
				.route(p -> p.path("/categorias/**").filters(
						f -> f.circuitBreaker(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8193"))
				.build();
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("Por favor, tente mais tarde!");
	}

	private static Logger log = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando o Gateway da Aplicação...");
		SpringApplication.run(GatewayApplication.class, args);
		log.info("Gateway da Aplicação iniciado!");
	}

}
