package reglas;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Vehiculo;

public class ReglaPlacaTest  {
	Vehiculo vehiculo;
	ReglasParqueo reglas;
	@Test
	public void PlacaEsA (){
		vehiculo=new Carro("FGN887");
		reglas = mock(ReglaPlaca.class);
		when(reglas.validar(vehiculo)).thenReturn(false);
		Assert.assertFalse(reglas.validar(vehiculo));
		
	}
	@Test
	public void PlacaNoEsA (){
		vehiculo=new Carro("FGN887");
		reglas = mock(ReglaPlaca.class);
		when(reglas.validar(vehiculo)).thenReturn(true);
		Assert.assertTrue(reglas.validar(vehiculo));
		
	}

}
