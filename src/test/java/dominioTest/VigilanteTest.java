package dominioTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Factura;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.Vigilante;
import reglas.ReglaDisponibilidad;
import reglas.ReglaPlaca;
import reglas.ReglasParqueo;

public class VigilanteTest {

	private Parqueadero parqueadero=new Parqueadero(20, 10);
	private List<ReglasParqueo> reglasParqueo=new ArrayList<>();
	private Vigilante vigilante = new Vigilante(parqueadero,anadirreglas());
	private Vehiculo vehiculo;
	private List<ReglasParqueo> anadirreglas() {
		reglasParqueo.add(new ReglaDisponibilidad());
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}
	
	@Test
	public void ingresarTest(){
		vehiculo=new Carro("FGN887");
		Factura factura=vigilante.ingresarVehiculo(vehiculo);
		Assert.assertNotNull(factura);
	}
	
}
