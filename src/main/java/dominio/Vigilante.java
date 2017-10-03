package dominio;

import java.util.Calendar;
import java.util.List;

import reglas.ReglasParqueo;

public class Vigilante {
	
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	
	public Vigilante(Parqueadero parqueadero,List<ReglasParqueo> reglasParqueo){
		this.parqueadero=parqueadero;
		this.reglasParqueo=reglasParqueo;
	}
	
	public Factura ingresarVehiculo(Vehiculo vehiculo){
		for(ReglasParqueo regla:reglasParqueo ){
			regla.validar(vehiculo, parqueadero);
		}
		return new Factura(vehiculo, Calendar.getInstance());
	}
	
	
	

}
