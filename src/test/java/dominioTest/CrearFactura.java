package dominioTest;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.Calendar;

import dominio.Carro;
import dominio.Recibo;
import dominio.Vehiculo;

public class CrearFactura {

	private Vehiculo vehiculo;

	@Test
	public void crearFacturaIngreso() {
		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("FGN887");
		Recibo factura = new Recibo(vehiculo, Calendar.getInstance());
		Assert.assertNotNull(factura);
	}

	@Test
	public void crearFacturaSalida() {
		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("FGN887");
		Recibo factura = new Recibo( vehiculo, Calendar.getInstance(), Calendar.getInstance(),  200.0);
		Assert.assertNotNull(factura);
	}

}
