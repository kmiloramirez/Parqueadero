package dominioTest;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Factura;
import dominio.Vehiculo;

public class CrearFacturas {
	int numeroDeFactura=0001;
	Vehiculo vehiculo=new Carro("FGN887");
	Calendar fechaDeIngreso= Calendar.getInstance();
	Calendar fechaDeSalida= Calendar.getInstance();
	boolean estadoDeFactura= true;
	@Test
	public void facturaDeIngreso(){
		Factura factura=new Factura(vehiculo, fechaDeIngreso);
		Assert.assertNotNull(factura);
	}
	
	@Test
	public void facturaSalida(){
		Factura factura=new Factura(numeroDeFactura, vehiculo, fechaDeIngreso, fechaDeSalida, estadoDeFactura);
		Assert.assertNotNull(factura);
	}

}
