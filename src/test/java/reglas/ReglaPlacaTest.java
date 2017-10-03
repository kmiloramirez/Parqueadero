package reglas;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import dominio.Carro;
import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaPlacaTest  {
	Vehiculo vehiculo;
	ReglasParqueo reglas=new ReglaPlaca();
	Parqueadero parqueadero; 
	@Test
	public void PlacaEsAYLunes (){
		vehiculo=new Carro("AGN887");
		ReglaPlaca reglaPlaca=mock(ReglaPlaca.class);
		when(reglaPlaca.saberSiEsLunes()).thenReturn(true);
		Assert.assertEquals((reglas.validar(vehiculo, parqueadero)),(reglaPlaca.saberSiEsLunes()));
		
	}
	@Test
	public void PlacaNoEsA (){
		vehiculo=new Carro("FGN887");
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
		
	}

}
