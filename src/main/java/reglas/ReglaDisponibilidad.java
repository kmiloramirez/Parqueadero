package reglas;


import dominio.Parqueadero;
import dominio.Vehiculo;


public class ReglaDisponibilidad implements ReglasParqueo {



	
	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		return ((vehiculo.getTipo().equals("carro") && parqueadero.getCeldaCarros() > 0)
				|| (vehiculo.getTipo().equals("moto") && parqueadero.getCeldaMotos() > 0));
	}

}
