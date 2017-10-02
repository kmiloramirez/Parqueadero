package dominioTest;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;


public class CrearVehiculos {
	Vehiculo vehiculo;
	
	@Test
	public void recibirUnCarro(){
		vehiculo=new Carro("FGN887");
		Assert.assertNotNull(vehiculo);
	}
	@Test
	public void recibirUnaMoto(){
		vehiculo=new Moto("FG823C",150);
		Assert.assertNotNull(vehiculo);
	}
	
	
	
}
