package br.edu.infnet.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigserverApplication {

	private static Logger log = LoggerFactory.getLogger(ConfigserverApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando o Servidor de Configurações...");
		SpringApplication.run(ConfigserverApplication.class, args);
		log.info("Servidor de Configurações iniciado!");
	}

}
