package reglas;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;



import dominio.Carro;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.IngresoException;

public class ReglaPlacaTest  {
	Vehiculo vehiculo;
	ReglasParqueo reglas=new ReglaPlaca();
	Parqueadero parqueadero; 
	@Test
	public void PlacaEsAYLunes (){
		vehiculo=new Carro("AGN887");
		ReglaPlaca reglaPlaca=mock(ReglaPlaca.class);
		when(reglaPlaca.saberSiPuedeIngresar()).thenReturn(true);
		try {
			reglas.validar(vehiculo,parqueadero);
			fail();
			} catch (IngresoException e) {	
			Assert.assertEquals("solo puede ingresar los dias domingos o lunes vuelva pronto", e.getMessage());
			}
		
		
	}
	@Test
	public void PlacaNoEsA (){
		vehiculo=new Carro("FGN887");
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
		
	}

}
