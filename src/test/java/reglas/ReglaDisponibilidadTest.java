package reglas;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;


public class ReglaDisponibilidadTest {	
	Vehiculo vehiculo;
	ReglasParqueo reglas= new ReglaDisponibilidad();
	Parqueadero parqueadero; 
	
	@Test
	public void validarDisponibilidadMoto(){
		vehiculo=new Moto("FG823C",150);
		parqueadero = new Parqueadero(20,10);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
		
	}
	
	@Test
	public void validarDisponibilidadCarro(){
		vehiculo=new Carro("FGN887");
		parqueadero = new Parqueadero(20,10);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
	}
	@Test
	public void validarDisponibilidadMotoFalso(){
		vehiculo=new Moto("FG823C",150);
		parqueadero = new Parqueadero(20,0);
		Assert.assertFalse(reglas.validar(vehiculo, parqueadero));
		
	}
	
	@Test
	public void validarDisponibilidadCarroFalso(){
		vehiculo=new Carro("FGN887");
		parqueadero = new Parqueadero(0,10);
		Assert.assertFalse(reglas.validar(vehiculo, parqueadero));
	}
	
	

}
