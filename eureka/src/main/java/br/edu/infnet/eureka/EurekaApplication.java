package br.edu.infnet.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	private static Logger log = LoggerFactory.getLogger(EurekaApplication.class);
	
	public static void main(String[] args) {
		log.info("Iniciando o Eureka Discovery Server...");
		SpringApplication.run(EurekaApplication.class, args);
		log.info("Eureka Discovery Server iniciado!");
	}
}
