package com.parqueadero.vigilante;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/ingresarCarro", method = RequestMethod.POST)
	@ResponseBody
	public Factura ingresarUnMoto(@RequestBody Carro carro){
		return vigilante.ingresarVehiculo(carro);
		
	}

}
