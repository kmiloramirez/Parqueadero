package com.parqueadero.vigilante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dominio.Parqueadero;
import dominio.Vigilante;
import dominio.repositorio.RepositorioRecibo;
import dominio.repositorio.RepositorioVehiculo;
import reglas.ReglaDisponibilidad;
import reglas.ReglaPlaca;
import reglas.ReglasParqueo;

@Configuration
public class VigilanteConfig {
	

	@Bean
	public Vigilante crearVigilante(RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo ){
		return new Vigilante(crearParqueadero(), anadirreglas(),repositorioVehiculo,repositorioRecibo);
	}
	
	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}
	
	private List<ReglasParqueo> anadirreglas() {
		List<ReglasParqueo> reglasParqueo=new ArrayList<>();
		reglasParqueo.add(new ReglaDisponibilidad());
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}

}
