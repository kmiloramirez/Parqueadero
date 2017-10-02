package com.parqueadero.vigilante;

import org.springframework.context.annotation.Bean;

import dominio.Parqueadero;

public class VigilanteConfig {
	
	@Bean
	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}

}
