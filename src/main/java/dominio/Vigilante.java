package dominio;

import java.util.Calendar;
import java.util.List;

import dominio.repositorio.RepositorioVehiculo;
import reglas.ReglasParqueo;

public class Vigilante {
	
	
	private RepositorioVehiculo repositorioVehiculo;
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	
	public Vigilante(Parqueadero parqueadero,List<ReglasParqueo> reglasParqueo,RepositorioVehiculo repositorioVehiculo){
		this.parqueadero=parqueadero;
		this.reglasParqueo=reglasParqueo;
		this.repositorioVehiculo=repositorioVehiculo;
	}
	
	public Factura ingresarVehiculo(Vehiculo vehiculo){
		for(ReglasParqueo regla:reglasParqueo ){
			regla.validar(vehiculo, parqueadero);
		}
		if(vehiculo.getTipo().equals("carro")){
			Carro carro=new Carro(vehiculo.getPlaca());
			repositorioVehiculo.agregarCarro(carro);
		}
		
		return new Factura(vehiculo, Calendar.getInstance());
	}
	
	
	

}
