package dominioTest;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.Calendar;

import dominio.Carro;
import dominio.Factura;
import dominio.Vehiculo;

public class CrearFactura {

	private Vehiculo vehiculo;

	@Test
	public void crearFacturaIngreso() {
		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("FGN887");
		Factura factura = new Factura(vehiculo, Calendar.getInstance());
		Assert.assertNotNull(factura);
	}

	@Test
	public void crearFacturaSalida() {
		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("FGN887");
		Factura factura = new Factura( vehiculo, Calendar.getInstance(), Calendar.getInstance(), false, 200.0);
		Assert.assertNotNull(factura);
	}

}
