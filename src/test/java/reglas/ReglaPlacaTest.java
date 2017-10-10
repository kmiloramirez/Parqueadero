package reglas;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import dominio.Carro;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;

public class ReglaPlacaTest {
	Vehiculo vehiculo;
	ReglasParqueo reglas = new ReglaPlaca();
	Parqueadero parqueadero;

	@Test
	public void PlacaEsAYNoEsDiaHabil() {
		vehiculo = new Carro("AGN887");
		ReglaPlaca reglaPlaca = mock(ReglaPlaca.class);
		when(reglaPlaca.saberSiPuedeIngresar()).thenReturn(true);
		try {
			reglas.validar(vehiculo, parqueadero);
		} catch (ParqueoException e) {
			Assert.assertEquals("solo puede ingresar los dias domingos o lunes vuelva pronto", e.getMessage());
		}

	}

	@Test
	public void PlacaNoEsA() {
		vehiculo = new Carro("FGN887");
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));

	}

}
