package com.parqueadero.vigilante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.Carro;
import dominio.Factura;
import dominio.Vigilante;

@RestController
@Transactional

public class VigilanteRest {
	
	@Autowired
	Vigilante vigilante;
	
	@RequestMapping(value = "/holaMundo", method = RequestMethod.POST)
	@ResponseBody
	public String hola(@RequestBody Carro carro){
		
		return carro.getPlaca();
		
	}
	@RequestMapping(value = "/ingresarCarro", method = RequestMethod.POST)
	@ResponseBody
	public Factura ingresarUnMoto(@RequestBody Carro carro){
		return vigilante.ingresarVehiculo(carro);
		
		
	}

}
