package reglas;

import java.util.Calendar;

import dominio.Factura;
import dominio.Vehiculo;

public class ReglaCobrar implements ReglasFacturacion {
	private int valorHoraCarro = 1000;
	private int valorHoraMoto = 500;
	private int valorDiaCarro = 8000;
	private int valorDiaMoto = 600;

	@Override
	public Factura ingresar(Vehiculo vehiculo) {
		return new Factura(vehiculo, Calendar.getInstance());
	}

	@Override
	public Factura cobrar(Factura factura) {
		if (factura.getVehiculo().getTipo().equals("moto")) {

		}
		if (factura.getVehiculo().getTipo().equals("carro")) {

		}
		return null;
	}
	
	private Factura cobrarCarro(Factura factura){
		
		return factura;
		
	}
	
	private Factura cobrarMoto(Factura factura){
		return factura;
		
	}

}
