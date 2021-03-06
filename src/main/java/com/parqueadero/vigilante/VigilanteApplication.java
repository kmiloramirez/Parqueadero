package com.parqueadero.vigilante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"dominio","persistencia.repositorio"," com.parqueadero.vigilante"})
@EntityScan("persistencia.entidad")

public class VigilanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigilanteApplication.class, args);
	}
}
