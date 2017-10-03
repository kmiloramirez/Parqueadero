package com.parqueadero.vigilante;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.Carro;
import dominio.Factura;
import dominio.Moto;

@RestController
public class VigilanteRest {
	
	@RequestMapping(value = "/ingresarMoto", method = RequestMethod.POST)
	@ResponseBody
	public Factura ingresarUnVehiculo(@RequestBody Moto moto){
		return null;
		
	}
	@RequestMapping(value = "/ingresarCarro", method = RequestMethod.POST)
	@ResponseBody
	public Factura ingresarUnVehiculo(@RequestBody Carro carro){
		return null;
		
	}

}
