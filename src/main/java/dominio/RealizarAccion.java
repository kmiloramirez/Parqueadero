package dominio;

public class RealizarAccion {
	
	
	public void executeSiCarro(Vehiculo vehiculo, Accion accion){		
		if(vehiculo instanceof Carro){
			accion.execute();			
			
		}		
	}
	
	public void executeSiMoto(Vehiculo vehiculo, Accion accion){		
		if(vehiculo instanceof Moto){
			accion.execute();			
			
		}		
	}

}
