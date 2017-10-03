package com.parqueadero.vigilante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import dominio.Parqueadero;
import dominio.Vigilante;
import reglas.ReglaDisponibilidad;
import reglas.ReglaPlaca;
import reglas.ReglasParqueo;


public class VigilanteConfig {
	

	
	@Bean
	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}
	@Bean
	public Vigilante crearVigilante(){
		return new Vigilante(crearParqueadero(), anadirreglas());
	}
	private List<ReglasParqueo> anadirreglas() {
		List<ReglasParqueo> reglasParqueo=new ArrayList<>();
		reglasParqueo.add(new ReglaDisponibilidad());
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}

}
