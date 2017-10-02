package reglas;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;


public class ReglaDisponibilidadTest {
	Vehiculo vehiculo;
	Reglas reglas;
	
	@Test
	public void validarDisponibilidadMoto(){
		vehiculo=new Moto("FG823C",150);
		reglas = mock(ReglaDisponibilidad.class);
		when(reglas.validar(vehiculo)).thenReturn(true);
		Assert.assertTrue(reglas.validar(vehiculo));
		
	}
	
	@Test
	public void validarDisponibilidadCarro(){
		vehiculo=new Carro("FGN887");
		reglas=mock(ReglaDisponibilidad.class);
		when(reglas.validar(vehiculo)).thenReturn(true);
		Assert.assertTrue(reglas.validar(vehiculo));
	}
	@Test
	public void validarDisponibilidadMotoFalso(){
		vehiculo=new Moto("FG823C",150);
		reglas=mock(ReglaDisponibilidad.class);
		when(reglas.validar(vehiculo)).thenReturn(false);
		Assert.assertFalse(reglas.validar(vehiculo));
		
	}
	
	@Test
	public void validarDisponibilidadCarroFalso(){
		vehiculo=new Carro("FGN887");
		reglas=mock(ReglaDisponibilidad.class);
		when(reglas.validar(vehiculo)).thenReturn(false);
		Assert.assertFalse(reglas.validar(vehiculo));
	}
	
	

}
